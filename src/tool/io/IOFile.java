/*
 * This file is to implement I/O processes based on txt files.
 * 
 * The data structure storing the strings is dynamic array: Class List<String>
 */

package tool.io;

import java.io.*;
import java.util.*;

public class IOFile {
	
	public static List<String> readFile(String string)
	{
	
		List<String> list = new ArrayList<String>();
		try
		{
			
		String line;	
		File file = new File(string);
		FileInputStream fis = new FileInputStream(new File(file.getCanonicalPath()));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		while((line = br.readLine())!=null)
			
		{	
			list.add(line);
			
		} 
		br.close();
		file = null;
		fis = null;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		
		
		
		return list;
	}
	
	public static void writeFile(List<String> list,String string,boolean bl)
	{
		
		 boolean b = bl;
		
		 try
	        
	        {
			      File file1 = new File(string);
			      BufferedWriter out=new BufferedWriter(new FileWriter(file1,true));
			      
			      for (int m=0; m<list.size(); m++) 
			      {
			    	  if (b)
			    	  {
			    		  out.write(list.get(m)+"  "+String.valueOf(m+1));
			    	  }
			    	  else
			    	  {
			    		  out.write(list.get(m));
			    	  }
			    	  
			    	  
			    	  if(m < list.size()-1)
			    	  {
			    		  out.newLine();
			    	  }
			    	  
			      }
			      out.close();
			      out=null;
			      file1=null;
			}
			    
	        catch (Exception ex) {}  
	}
}
