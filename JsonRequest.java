package io.batumutsu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * @author JEAN BAPTISTE
 *
 */
public class JsonRequest {
	
	
	public static void main(String[] args) {
	     try {
	         JsonRequest.call_me();
	        } catch (Exception e) {
	         e.printStackTrace();
	       }
	     }
		   
	public static void call_me() throws Exception {
		String url = "https://df-dev.bk.rw/interview01/transactions"; 
		URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	     System.out.println(response.toString());
	     //Read JSON response and print
	     JSONObject myResponse = new JSONObject(response.toString());
	     System.out.println("result after Reading JSON Response");
	     System.out.println("Transaction_Id: "+myResponse.getString("Transaction_Id"));
	     System.out.println("DateTime: "+myResponse.getString("DateTime"));
	     System.out.println("Customer_Id: "+myResponse.getString("Customer_Id"));
	     System.out.println("Customer_Name: "+myResponse.getString("Customer_Name"));
	     System.out.println("Amount: "+myResponse.getString("Amount"));
	     System.out.println("City_Name: "+myResponse.getString("City_Name"));
	     }

}
