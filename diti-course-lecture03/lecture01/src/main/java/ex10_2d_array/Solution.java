package ex10_2d_array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// Дан массив 6х6
//1 1 1 0 0 0
//0 1 0 0 0 0
//1 1 1 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//
//Будем искать сумму элементов, образующих следующий узор:
//  a b c
//    d
//  e f g
//
//К примеру, для массива
//-9 -9 -9  1 1 1
// 0 -9  0  4 3 2
//-9 -9 -9  1 2 3
// 0  0  8  6 6 0
// 0  0  0 -2 0 0
// 0  0  1  2 4 0
//
// значениями узоров будет:
//-63, -34, -9, 12,
//-10, 0, 28, 23,
//-27, -11, -2, 10,
//9, 17, 25, 18
//
//Наибольшее значение - 28
//Входные параметры 6x6 массив, выходные - наибольшее значение суммы элементов, образующих наш узор
//
//Ограничения: -9<=arr[i][j]<=9
//             0<=i,j<=5
public class Solution {
    static int hourglassSum(int[][] arr) {
        //TODO:
        throw new UnsupportedOperationException();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
