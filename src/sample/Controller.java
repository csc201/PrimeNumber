package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    Label output;
    @FXML
    TextField input;

    public void displayPrime() {
        int SIZE = Integer.parseInt(input.getText());
        int i=1;
        String out = "";
        do {
            if(isPrime(i) && (i!=SIZE)) {
                out += i + ", ";
            } else if(isPrime(i) && (i==SIZE)) {
                out += i + ".";
            }
            i++;
        } while(i<=SIZE);
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
}
