package io.batumutsu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlRequest {
	
	/**
	 * @author JEAN BAPTISTE
	 */
	public static void main(String[] args) {
		 XmlRequest Myobject=new XmlRequest();
		 Myobject.get_response();
		}
		public void get_response(){
		try {
		 String url = "https://df-dev.bk.rw/interview01/customers";
		 System.out.println(url);
		 URL obj = new URL(url);
		 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 int responseCode = con.getResponseCode();
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
		        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
		         .parse(new InputSource(new StringReader(response.toString())));
			NodeList errNodes = doc.getElementsByTagName("City_Totals");
		        if (errNodes.getLength() > 0) {
		          Element err = (Element)errNodes.item(0);
		          System.out.println("City_Name: "+err.getElementsByTagName("City_Name").item(0).getTextContent());
		          System.out.println("Total_Amount: "+err.getElementsByTagName("Total_Amount").item(0).getTextContent());
		          System.out.println("Unique_Customers: "+err.getElementsByTagName("Unique_Customers").item(0).getTextContent());
		          System.out.println("Total_Transactions: "+err.getElementsByTagName("Total_Transactions").item(0).getTextContent());
			} else { 
				     // success
		         }
		        System.out.println(doc);
			} catch (Exception e) {
			   System.out.println(e);
			}
			}


}
