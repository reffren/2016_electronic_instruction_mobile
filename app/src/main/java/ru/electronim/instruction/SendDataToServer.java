package ru.electronim.instruction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Tim on 01.06.2016.
 */
public class SendDataToServer {

    String link = "http://stockcom.ru/accept";
    String sendIdToServer;

    ArrayList<String> updateServer;
    DataBaseAdapter dataBaseAdapteradapter;
    int sizeUpdateServer;

    protected void sendData(DataBaseAdapter adapter) throws IOException {

        dataBaseAdapteradapter = adapter;
        updateServer = new ArrayList<>();
        updateServer = dataBaseAdapteradapter.getDataForUpdate();
        sizeUpdateServer = updateServer.size();
        for(int i = 0; i<sizeUpdateServer; i++) {
            if (i == 0) {  //для начала строки (строка начинается)
                sendIdToServer = URLEncoder.encode(String.valueOf(i), "UTF-8") + "=" + URLEncoder.encode(String.valueOf(updateServer.get(i)), "UTF-8");
            } else { //продолжение строки (строка продолжается)
                sendIdToServer += "&" + URLEncoder.encode(String.valueOf(i), "UTF-8") + "=" + URLEncoder.encode(String.valueOf(updateServer.get(i)), "UTF-8");
            }
        }


        URL url = new URL(link);
        URLConnection conn = url.openConnection();

        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

        wr.write(sendIdToServer);
        wr.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));


    }
}
