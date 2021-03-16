package sample;

public class Helper {
    //validate the student name, only allows a-z upper and lower case
    //and space between
    public static boolean validateName(String userName){
        return userName.matches("^[a-zA-Z\\s]+$");
    }
    //validate student ID number, accepts a 7 digit number (a string)
    //For example: 0668096 (Trent Student ID)
    public static boolean validateID(String number){
        return number.matches("^[\\d+]{7}+$");
    }
}
