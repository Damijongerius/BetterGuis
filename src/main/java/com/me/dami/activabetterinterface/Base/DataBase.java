package com.me.dami.activabetterinterface.Base;

import java.sql.*;

public class DataBase {
    private static Connection connection;

    public DataBase(String _name, String _password, String _url){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(_url, _name, _password);
            System.out.println("Connection to DataBase succesfull...");

        } catch (SQLException e) { // catching errors
            System.out.println("Error while connecting to database...");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
