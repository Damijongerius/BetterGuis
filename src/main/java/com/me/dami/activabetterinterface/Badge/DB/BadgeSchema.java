package com.me.dami.activabetterinterface.Badge.DB;

import com.me.dami.activabetterinterface.ActivaBetterInterface;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class BadgeSchema {

    private ActivaBetterInterface main;

    public BadgeSchema(ActivaBetterInterface _main){
        main = _main;
    }

    public void LoadSchema() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://github.com/username/repository/raw/master/path/to/file.txt");
        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String content = EntityUtils.toString(response.getEntity());
            FileOutputStream fos = new FileOutputStream("path/to/local/file.txt");
            fos.write(content.getBytes());
            fos.close();
        }
    }
}
