package ru.diti.converter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import javafx.scene.control.TextField;
import ru.diti.converter.enums.Currency;
import ru.diti.converter.service.ConverterService;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.math.BigDecimal;

public class ConverterController {
    private final ConverterService converterService = new ConverterService();

    // @FXML
    // private Text actiontarget;
    @FXML
    private TextField actiontarget;
    @FXML
    private TextField money;
    @FXML
    private ComboBox<Currency> currencyFrom;

    @FXML
    private ComboBox<Currency> currencyTo;
///////////////////////////////////////////////

    /////////////////////////////
    @FXML
    private void handleConvertAction() {
        if (validate()){
            try{
                actiontarget.setText(converterService.convert(new BigDecimal(money.getText()), currencyFrom.getValue(), currencyTo.getValue()));
            }
            catch (IOException exe){
                actiontarget.setText("Error");
            }
        }
    }
    private boolean validate() {
        float sum = 0;
        try {
            sum = Float.parseFloat(money.getText());
        }
        catch (NumberFormatException exe) {
            if (!money.getText().isEmpty()) {//предложил перейти на 6 уровень не знаю что это значит
                actiontarget.setText("You pressed the string");
            }
            return false;
        }
        if (sum < 0) {
            actiontarget.setText("The number is negative");
            return false;
        }
        return true;

     /* String text=money.getText();
      float value = 0.0f;
      try{value=Float.parseFloat(text);}
      catch(Exception exe){
          actiontarget.setText("You pressed the string");
          return false;
      }
      if (value<=0){
          actiontarget.setText("Error,number is negative");
          return false;
      }*/
    }

    public void handleReverseButtonAction(ActionEvent actionEvent) {
        Currency R = currencyFrom.getValue();
        currencyFrom.setValue(currencyTo.getValue());
        currencyTo.setValue(R);
    }
}
