/*this file is to implement methods which can send inquires of key words into Bing server and get the results of search in JSON format.
 * 
 * This file is based on loading external java libraries called json-20090211.jar and commons=codec-1.8.jar.
 * 
 * 
 */
package search.web;

import java.io.*;
import java.net.*;
import org.json.JSONObject;
import org.json.JSONArray;

import org.apache.commons.codec.binary.*;
 
public class Searcher 

{    // type of action sent into Bing server
	 static String QUERY = "&Query=%27";
	 
	 //search parameters,
	 static String  searchParam = "$format=JSON&$top=";
	 
	 // URl used for sending keywords into server
	 static String searchURL = "https://api.datamarket.azure.com/Bing/Search/Web?";
	 
	 // account key to access to search service maintained by Bing 
	 static String accountKey = "IqUzNWwwqNzyCxOC5LhhiTxmr1omv6BnGQW7wXe1uKs";
	 static String accountKeyEnc = new String(Base64.encodeBase64((accountKey+":"+accountKey).getBytes()));
	 
	 // define the number of records sent by Bing server
	 private int n;
	 
	 private JSONObject res = null;
	 private JSONArray jsonarr  = null;
	 private String [] str = null; 
	 
    
	 public Searcher(int n) 
    
    {
        this. n = n;
    }
 
    public void search(String keyword) 
    
    {   
    	str = new String[n];
        URL url = null;
        try 
        {           // link strings together to form the final inquiry URL 
                    url = new URL(searchURL + searchParam + n + QUERY + URLEncoder.encode(keyword, "UTF-8") +"%27");
                    
                    URLConnection conn = url.openConnection(); 
                    conn.setRequestProperty("Authorization","Basic " + accountKeyEnc);
                    
                    // get input stream
                    StringBuilder builder = new StringBuilder();
                    BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream(), "utf-8"));
                    
                    // read the contents from the flow
                    String line;
                    while ((line = br.readLine()) != null)
                    
                    {
                        builder.append(line);
                    }
                    br.close();
                    
                    
                    // extract useful information from JSON object.
                    String s = builder.toString();
                    
                    res = new JSONObject(s);
                    
                    
                    // JSON format {"d":{"results":["Description":]......
                    jsonarr = res.getJSONObject("d").getJSONArray("results");
                    
                    for (int j = 0; j < jsonarr.length();j++)
                    {
                    	JSONObject temp = jsonarr.getJSONObject(j);
                    	str[j] = temp.getString("Url");
                    }
  
        } 
        
        catch (MalformedURLException e)       
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	
        }
    }
    
    public JSONObject getRes()
    {
    	return res;
    }
    
    public JSONArray getJsonArray()
    {
    	return jsonarr;
    }
    public String[] getStringarray()
    {
    	return str;
    }
  
    public int getNumber()
    {
    	return n;
    }
}