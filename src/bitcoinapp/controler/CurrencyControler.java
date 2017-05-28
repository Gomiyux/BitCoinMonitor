/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoinapp.controler;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author carlo
 */
public class CurrencyControler {

    private double EUR;
    private double GPB;
    private double MXN;
    private double CHF;
    private double BRL;
    private double PLN;
    private double JPY;
    private double CNY;
    private double RUB;
    private double INR;
    private double TRY;
    private double SEK;

    public CurrencyControler() {
        StringBuffer text = new StringBuffer();

        try {
            URL url = new URL("http://api.fixer.io/latest?base=USD");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
//          connection.setRequestProperty("Accept-Encoding", "gzip"); // we will avoid encoding for our tutorial because decompressing will complicate things
            //connection.setRequestProperty("User-Agent", "breekmd.wordpress.com-tutorial");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
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

        HashMap divises = (HashMap) map.get("rates");

        EUR = Double.parseDouble(divises.get("EUR").toString());
        GPB = Double.parseDouble(divises.get("GBP").toString());
        MXN = Double.parseDouble(divises.get("MXN").toString());
        CHF = Double.parseDouble(divises.get("CHF").toString());
        BRL = Double.parseDouble(divises.get("BRL").toString());
        PLN = Double.parseDouble(divises.get("PLN").toString());
        JPY = Double.parseDouble(divises.get("JPY").toString());
        CNY = Double.parseDouble(divises.get("CNY").toString());
        RUB = Double.parseDouble(divises.get("RUB").toString());
        INR = Double.parseDouble(divises.get("INR").toString());
        TRY = Double.parseDouble(divises.get("TRY").toString());
        SEK = Double.parseDouble(divises.get("SEK").toString());
    }

    

    public void refresh() {
        StringBuffer text = new StringBuffer();

        try {
            URL url = new URL("http://api.fixer.io/latest?base=USD");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
//          connection.setRequestProperty("Accept-Encoding", "gzip"); // we will avoid encoding for our tutorial because decompressing will complicate things
            //connection.setRequestProperty("User-Agent", "breekmd.wordpress.com-tutorial");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
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

        HashMap divises = (HashMap) map.get("rates");

        EUR = Double.parseDouble(divises.get("EUR").toString());
        GPB = Double.parseDouble(divises.get("GBP").toString());
        MXN = Double.parseDouble(divises.get("MXN").toString());
        CHF = Double.parseDouble(divises.get("CHF").toString());
        BRL = Double.parseDouble(divises.get("BRL").toString());
        PLN = Double.parseDouble(divises.get("PLN").toString());
        JPY = Double.parseDouble(divises.get("JPY").toString());
        CNY = Double.parseDouble(divises.get("CNY").toString());
        RUB = Double.parseDouble(divises.get("RUB").toString());
        INR = Double.parseDouble(divises.get("INR").toString());
        TRY = Double.parseDouble(divises.get("TRY").toString());
        SEK = Double.parseDouble(divises.get("SEK").toString());
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getGPB() {
        return GPB;
    }

    public void setGPB(double GPB) {
        this.GPB = GPB;
    }

    public double getMXN() {
        return MXN;
    }

    public void setMXN(double MXN) {
        this.MXN = MXN;
    }

    public double getCHF() {
        return CHF;
    }

    public void setCHF(double CHF) {
        this.CHF = CHF;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    public double getPLN() {
        return PLN;
    }

    public void setPLN(double PLN) {
        this.PLN = PLN;
    }

    public double getJPY() {
        return JPY;
    }

    public void setJPY(double JPY) {
        this.JPY = JPY;
    }

    public double getCNY() {
        return CNY;
    }

    public void setCNY(double CNY) {
        this.CNY = CNY;
    }

    public double getRUB() {
        return RUB;
    }

    public void setRUB(double RUB) {
        this.RUB = RUB;
    }

    public double getINR() {
        return INR;
    }

    public void setINR(double INR) {
        this.INR = INR;
    }

    public double getTRY() {
        return TRY;
    }

    public void setTRY(double TRY) {
        this.TRY = TRY;
    }

    public double getSEK() {
        return SEK;
    }

    public void setSEK(double SEK) {
        this.SEK = SEK;
    }

}
