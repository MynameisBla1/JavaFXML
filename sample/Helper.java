package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
    //create the database file
    public static Connection ConnectToDatabase(){
        try{

            Connection conn =
                    DriverManager.getConnection("JDBC:sqlite:testjava.db");
            return conn;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return null;

        }
    }
    //create the table
    public static boolean CreateTable(Connection conn){
        try{

            Statement query = conn.createStatement();

            query.execute("CREATE TABLE IF NOT EXISTS users (studentName TEXT, ID TEXT)");
            return true;

        }catch(SQLException e){
            System.out.println("Error: " +  e.getMessage());
            return false;
        }
    }
    //save valid user input into the database
    public static boolean InsertRecord(Connection conn, String userName, String ID){

        try{

            Statement query = conn.createStatement();
            query.execute("INSERT INTO users VALUES('"+userName+"','"+ID+"')");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


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
