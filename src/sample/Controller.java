package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    Label output;
    @FXML
    TextField input;
    @FXML
    ChoiceBox<String> options;

    public void setChoiceBox() {
        System.out.println("set choice box");
        ObservableList<String> observableList = FXCollections.observableArrayList(Constants.PRIME_TEXT,Constants.FACTORIAL_TEXT,Constants.ODD_NUMBER_TEXT,Constants.EVEN_NUMBER_TEXT);
        options = new ChoiceBox<String>(observableList);
        options.setValue(Constants.PRIME_TEXT);
    }

    public void display() {

        int SIZE = 0;
        if(!input.getText().equals("")) {
            SIZE = Integer.parseInt(input.getText());
        }

        int i=1;
        String out = "";
        System.out.println(options.getSelectionModel().getSelectedItem());
        //options.setSelectionModel();
        if(options.getSelectionModel().getSelectedItem().equals(Constants.PRIME_TEXT)) {
            do {
                if (isPrime(i) && (i != SIZE)) {
                    out += i + ", ";
                } else if (isPrime(i) && (i == SIZE)) {
                    out += i + ".";
                }
                i++;
            } while (i <= SIZE);
        } else if (options.getSelectionModel().getSelectedItem().equals("Factorial")) {
                out = String.valueOf(factorial(SIZE));
        } else if (options.getSelectionModel().getSelectedItem().equals("Odd Number")) {

        }
        output.setText(out);
    }

    public static boolean isPrime(int number) {
        boolean prime = false;
        int i=1;
        int count=0;
        do {
            if(number%i == 0) { //if it is not divided by it self and get 0
                if(number==1) {
                    prime= false;
                } else if(i==number && count==1){
                    prime = true;
                } else {
                    prime = false;
                    count++;
                }
            }
            i++;
        } while (i<=number);
        return prime;
    }

    public int factorial(int n) {
        int result = 1;
        if(n==1 || n==0) {
            result = result;
        } else {
            result = n * factorial(n-1);
        }
        return result;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
