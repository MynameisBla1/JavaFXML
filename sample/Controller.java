package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField name;
    @FXML
    private TextField ID;
    @FXML
    private Button LogIn;


    public void onButtonClicked(){
        Helper.CreateTable(Helper.ConnectToDatabase());
        boolean valid = true;
        String userName =name.getText(); //get Student name
        //show this message if the user enters invalid name
        if(Helper.validateName(userName)==false){
            System.out.println("ERROR: Invalid Name");
            valid = false;
        }else{  //otherwise, show this
            System.out.println("Student Name is valid.");
        }
        //get Student ID
        String number = ID.getText();
        //show error message if the user enters invalid ID number
        if(Helper.validateID(number)==false){
            System.out.println("ERROR: Invalid Student ID");
            valid = false;
        }else{      //otherwise, print this
            System.out.println("Student ID is valid");
        }
        if(valid ==true){
           LogIn.setDisable(true);
            Helper.InsertRecord(Helper.ConnectToDatabase(), userName, number);
            System.out.println("Your input was saved into the database.");
        }

    }

}
