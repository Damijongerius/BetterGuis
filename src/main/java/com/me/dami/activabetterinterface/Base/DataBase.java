package com.me.dami.activabetterinterface.Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static Connection connection;

    public DataBase(String _name, String _password, String _url){
        try {
            connection = DriverManager.getConnection(_url, _name, _password);
            System.out.println("Connection to DataBase succesfull...");

        } catch (SQLException e) { // catching errors
            System.out.println("Error while connecting to database...");
            e.printStackTrace();
        }
    }

    public void onDisable() {
        try {
            if (connection!=null && !connection.isClosed()){
                connection.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
