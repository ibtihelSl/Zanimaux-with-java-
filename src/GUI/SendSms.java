/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import sun.misc.BASE64Encoder;
 
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
 
/**
 *
 * @author ci
 */
public class SendSms {
    
    public final static String username = "nouha";
    public final static String password = "Allahmohamed111";
 
    public static void main(String[] args) throws IOException {
       
 
        int result = send(username, password, " +21693765339", " Bienvenue dans notre site ");  
        System.out.println("Result code: " + result);
    }
 
    /**
     * Send an sms message.
     *
     * @param user Bulletin API user name
     * @param pass Bulletin API password
     * @param to the number to send the message to
     * @param messageId the threading identifier you want to use
     * @param body the message
     * @throws IOException if the HTTP POST fails
     * @return the HTTP result code
     */
 
    public static int send(String user, String pass, String to,  String body) throws IOException {
        URL url = new URL("https://www.bulletinmessenger.net/api/3/sms/out");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", encodeBasicAuth(user, pass));
            con.setDoOutput(true);
 
            StringBuffer form = new StringBuffer();
            form.append("to=");
            form.append(to);
           // form.append("&messageId=").append(messageId);
            form.append("&body=");
 
            form.append (URLEncoder.encode(body, "UTF-8"));
 
            OutputStream out = con.getOutputStream();
            try {
                out.write(form.toString().getBytes("US-ASCII"));
            } finally {
                out.close();
            }
            return con.getResponseCode();
        } finally {
            con.disconnect();
        }
    }
 
    public static String encodeBasicAuth(String user, String pass) throws UnsupportedEncodingException {
        byte[] credentials = (user + ':' + pass).getBytes("US-ASCII");
        return "Basic " + new BASE64Encoder().encode(credentials);
    }
 
    }
    
    
    

