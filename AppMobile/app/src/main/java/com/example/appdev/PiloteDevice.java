package com.example.appdev;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class PiloteDevice implements Runnable {

    private int devId;
    private String action;
    private String serveur;
    public PiloteDevice(String serveur, int devId,String action) {
        this.devId=devId;
        this.action=action;
        this.serveur=serveur;
    }

    public void run(){
        HttpURLConnection urlConnection;
        urlConnection = null;

        try {
            URL url = new URL("http://"+serveur+":5000/action/"+String.valueOf(devId)+"/"+action);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setAllowUserInteraction(true);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            String buffer = scanner.nextLine();
            scanner.close();
        }
        catch(Exception e){
            e.printStackTrace();}
        finally{
            if(urlConnection != null) urlConnection.disconnect();
        }

    }
}
