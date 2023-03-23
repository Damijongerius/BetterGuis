package com.me.dami.activabetterinterface.Badge.DB;

import com.me.dami.activabetterinterface.Base.DataBase;

import java.sql.Connection;

public abstract class Connector {
    private Connection conn;
    protected Connection Connection(){
        if(conn == null){
            conn = DataBase.GetConnection();
        }
        return conn;
    }
}
