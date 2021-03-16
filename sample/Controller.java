package sample;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField name;
    @FXML
    private TextField ID;

    public void onButtonClicked(){
        String userName =name.getText(); //get Student name
        //show this message if the user enters invalid name
        if(Helper.validateName(userName)==false){
            System.out.println("ERROR: Invalid Name");
        }else{  //otherwise, show this
            System.out.println("Student Name is Valid.");
        }
        //get Student ID
        String number = ID.getText();
        //show error message if the user enters invalid ID number
        if(Helper.validateID(number)==false){
            System.out.println("ERROR: Invalid Student ID");
        }else{      //otherwise, print this
            System.out.println("Student ID is valid");
        }

    }

}
