package com.me.dami.activabetterinterface.Badge.DB;

import com.me.dami.activabetterinterface.ActivaBetterInterface;


import com.me.dami.activabetterinterface.Base.DataBase;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BadgeSchema {

    private ActivaBetterInterface main;

    public BadgeSchema(ActivaBetterInterface _main){
        main = _main;
    }

    public void LoadSchema() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/Damijongerius/BetterGuis/master/DatabaseStructure.sql");
        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String content = EntityUtils.toString(response.getEntity());
            FileOutputStream fos = new FileOutputStream(main.getDataFolder().getPath() + "/DB/DatabaseStructure.sql");
            fos.write(content.getBytes());
            fos.close();
        }
    }

    public void ExecuteSchema() throws SQLException, ClassNotFoundException, IOException {

        Class.forName("com.mysql.jdbc.Driver");
        Statement stmt = DataBase.GetConnection().createStatement();

        FileReader reader = new FileReader(main.getDataFolder().getPath() + "/DB/DatabaseStructure.sql");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String sqlScript = "";
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            sqlScript += line + "\n";
        }

        boolean hasResultSet = stmt.execute(sqlScript);

        stmt.close();
        DataBase.GetConnection().createStatement();
    }
}
