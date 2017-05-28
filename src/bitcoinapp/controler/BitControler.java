/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoinapp.controler;


/**
 *
 * @author carlo
 */  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
 
import com.json.parsers.JSONParser; // can be downloaded from: https://code.google.com/p/quick-json/downloads/list
import com.json.parsers.JsonParserFactory; // and added to project properties 

public class BitControler {
    
    private double price;
    private Date date;

    public BitControler(){
        
        StringBuffer text = new StringBuffer();
        
        try {
            URL url = new URL("https://winkdex.com/api/v0/price");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
//          connection.setRequestProperty("Accept-Encoding", "gzip"); // we will avoid encoding for our tutorial because decompressing will complicate things
            connection.setRequestProperty("User-Agent", "breekmd.wordpress.com-tutorial");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null ) {
                text.append(line);
            }
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
        JsonParserFactory factory = JsonParserFactory.getInstance();
        JSONParser parser = factory.newJsonParser();
        Map map = parser.parseJson(text.toString());
        price = Double.parseDouble((String) map.get("price"))/100;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = df.parse((String) map.get("timestamp"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        /*
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy', 'HH:mm");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");*/
        
    }

    public void refresh(){
        
        StringBuffer text = new StringBuffer();
        
        try {
            URL url = new URL("https://winkdex.com/api/v0/price");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
//          connection.setRequestProperty("Accept-Encoding", "gzip"); // we will avoid encoding for our tutorial because decompressing will complicate things
            connection.setRequestProperty("User-Agent", "breekmd.wordpress.com-tutorial");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null ) {
                text.append(line);
            }
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonParserFactory factory = JsonParserFactory.getInstance();
        JSONParser parser = factory.newJsonParser();
        Map map = parser.parseJson(text.toString());
        price = Double.parseDouble((String) map.get("price"))/100;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = df.parse((String) map.get("timestamp"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        /*
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy', 'HH:mm");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("Date: " + dateFormat.format(date));
        System.out.println("Price: " + "$" + decimalFormat.format(price));
        System.out.println("Data Provided by WINKDEXSM.");*/
        
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
        
    
 

}
