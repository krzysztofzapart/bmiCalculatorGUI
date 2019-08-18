package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    TextField waist, chest, thigh, age, weight, height;
    @FXML
    Label fatText, bmiText;



    public void calculate() {

        try {
            final double A_1 = 457.0;
            final double A_2 = 414.2;
            final double B_1 = 495.0;
            final double B_2 = 450.0;


            final double ONE = 1.1093800;
            final double TWO = 0.0008267;
            final double THREE = 0.0000016;
            final double FOUR = 0.0002574;


            Integer chestValue = Integer.valueOf(chest.getText());
            Integer thighValue = Integer.valueOf(thigh.getText());
            Integer waistValue = Integer.valueOf(waist.getText());
            Integer ageValue = Integer.valueOf(age.getText());

            int summary = thighValue + waistValue + chestValue;
            double two = TWO * summary;
            double three = THREE * summary * summary;
            double four = FOUR * ageValue;

            double density = ONE - two + three - four;


            double body1 = (A_1 / density) - A_2;
            double body2 = ((B_1 / density) - B_2);
            double bodyFat = ((body1 + body2) / 2);
            double roundBodyFat = Math.round(bodyFat * 100) / 100;

            String fat = String.valueOf(roundBodyFat);
            fatText.setText(fat);


            Double weightValue = Double.valueOf(weight.getText());
            Double heightValue = Double.valueOf(height.getText());

            double bmi = weightValue / (heightValue * heightValue);
            double roundBmi = Math.round(bmi * 100) / 100;


            String stringBmi = String.valueOf(roundBmi);


            bmiText.setText(stringBmi);

        }catch (Exception e){
            //
        }
    }
    public void clear(){
        waist.clear();
        chest.clear();
        thigh.clear();
        age.clear();
        height.clear();
        weight.clear();
        fatText.setText("");
        bmiText.setText("");
    }


}
