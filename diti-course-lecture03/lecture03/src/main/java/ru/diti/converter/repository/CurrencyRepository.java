package ru.diti.converter.repository;

import ru.diti.converter.enums.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyRepository {
    private BufferedReader bufferedReader;
    public CurrencyRepository() {
        bufferedReader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("currency_pairs.txt")));
    }
    public BigDecimal getCoef(Currency from, Currency to) throws IOException {
        BigDecimal numerator = null;
        BigDecimal denominator = null;
        String parsedString;
        while ((parsedString = bufferedReader.readLine()) != null) {
            String[] string = parsedString.split(" ");
            if (from == to) return new BigDecimal("1");

            if (from == Currency.USD || to == Currency.USD) {
                if (from == Currency.USD && to.name().equals(string[1])) {
                    return new BigDecimal(string[2]);
                }
                if (to == Currency.USD && from.name().equals(string[1])) {
                    return new BigDecimal("1").divide(new BigDecimal(string[2]), 8, RoundingMode.HALF_EVEN);
                }
            }
            if (string[1].equals(from.name())) {
                denominator = new BigDecimal(string[2]);
            }
            if (string[1].equals(to.name())) {
                numerator = new BigDecimal(string[2]);
            }
            if (numerator != null && denominator != null) {
                break;
            }
        }
        return numerator.divide(denominator,8, RoundingMode.HALF_EVEN);
    }
    public void close()
            throws Exception {
        bufferedReader.close();
    }
}

