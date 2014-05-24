/* This file aims to provide methods which can process strings like printing strings, compare strings and so on.
 * 
 * method trimURL - tailor full website by cutting off "http://www.",".com",".com.au",".co.uk"... and ".*"
 * method trimCompany, trimPoint and trimSpace- tailor full company names by throwing out spaces and points.
 * 
 * method pringArray - print certain array
 * method printList  - print certain List(class)
 * 
 * method comapreArray - compare two strings and return the number of the same characters based on the order of the string from left to right.
 * 
 * method getKey- return the String list of ranking number of companies in original company list.
 * 
 * 
 */
package tool.process;

import java.util.*;
import tool.io.IOFile;

public class Tackle 

{   
	public static String trimURL(String string)
	{
        String tmp = null;
	    tmp = string.substring(string.indexOf("//")+2);		    
	    
	    if (tmp.startsWith("www."))
	    {
	    	tmp = tmp.substring(tmp.indexOf(".")+1);
	    }
	    
	   tmp = tmp.substring(0, tmp.indexOf("/"));
	   String tmp1 [] = tmp.split("\\.");
	    
        try
        {
        	if ((tmp1.length == 2)||(tmp1[tmp1.length-2].equals("com"))||(tmp1[tmp1.length-2].equals("co")))
		    {
		    	
		    		tmp = tmp1[0];
		    	//System.out.println(tmp1[0]);
		    }
        	else 
        	{
        		tmp = tmp1[1];
        	}  
        }
        catch(Exception e){}
        
      return  trimLine(tmp.toLowerCase());
       
	}
	
	public static String trimCompany(String string)
	{
		String s = trimPoint(trimSpace(trimLine(string)));
		return s.toLowerCase();	
	}
	
	public static String trimLine(String string)
	{
		String finaltmp="";
		if(string.indexOf("-")>=0)
        {
        	 String temp [] = string.split("-");
             
             for (int m = 0; m < temp.length; m++)
             {
          	   finaltmp+=temp[m];
             }
          	 
      	     
      		return finaltmp;
        }
        
        else
        {
        	return string;
        }
        
	}
	
	public static String trimSpace(String string)
	{
	    // decide whether the string contains the space.
		if (string.indexOf(" ")>=0)
	    {
	    	return string.replaceAll(" ", "");
	    }
	    else
		{
			return string;
		}
		
	}
	
	public static String trimPoint(String string)
	
	{
		if(string.indexOf(".")>=0)
		{
			return string.replaceAll("\\.", "");
		}
		
		else
		{
			return string;
		}
	}
	
	public static void printArray(String[] string)
	{
		for (int i = 0; i < string.length; i++)
		{
			System.out.println(string[i]);
			
		}
	}
	
	public static void printList(List<String> string)
	{
		for (int i = 0 ; i < string.size() ; i++)
		{
			System.out.println(string.get(i));
		}
	}
	public static void print(int i)
	{
		System.out.println(i);
	}
	
	public static int compareArray(String str1,String str2)
	{ 
		// to show the number of same characters of both strings
		int pointer = 0;
		// pointer to define the location of substring of str1
		int pointerStr1 = 0;
	    
		
		for (int i = 0; i < str2.length(); i++)
		{
			
		
				if (str2.substring(i,i+1).equals(str1.substring(pointerStr1,pointerStr1+1)))
				{
					
					++pointer;
					++pointerStr1;
				}
				
				
		if(pointerStr1 == str1.length())
			
		{
			break;
		}				
			
		}
		
		
	return pointer;
	
  }
	
   public static String[] getKey(List<String> string)
	{
		
		String [] key= new String[string.size()];
		
		for (int i = 0; i<string.size();i++)
			
		{
			
			
			String [] tmp1 = string.get(i).split(" ");
			
			key[i] = tmp1[tmp1.length-1];
		}
		
		return key;
		
		
	}
   
   public static List<String> addLine(List<String> string)
   {
	   List<String> list = new ArrayList<String>();
	   
	   for (int i = 0 ; i < string.size(); i++)
	   {
		   list.add(string.get(i));
		   list.add(" ");
	   }
	   
	   return list;
   }


   public static String  extractDomain(String str)
   {
	   String [] string = str.split("\\\\");
	   
	   String ss = string[3];
	   
	   return  ss;
   }
   
   public static List<String> removeDuplicate(List<String> list)
   {
	  Set<String> set = new HashSet<String>();
	  List<String> newlist = new ArrayList<String>();
	  
	  
	  for (Iterator<String> iter = list.iterator();iter.hasNext();)
	  {
		  String str = iter.next();
		  
		  if(set.add(str))
		  {
			  newlist.add(str);
		  }
	  }
	  
	  return newlist;
   }
   
   public static List<String> toList(List<List<String>> list)
   {
	   List<String> last = new ArrayList<String>();
	   for (int i = 0; i < list.size();i++)
		{
			for (int j = 0 ; j < list.get(i).size(); j++)
			{
				last.add(list.get(i).get(j));
			}
		}
		
	   return removeDuplicate(last);
   }
   
   public static String[] removeString(String [] string, String str)
   {
	  List<String> list = new ArrayList<String>();
	  
	  for (int i = 0 ; i < string.length ; i++)
	  {
		  String s = string[i];
		  
		  if (s.equalsIgnoreCase(str))
		  {
			  continue;
		  }
		  list.add(s);
			  
	  }
	  
	  return (String[])list.toArray(new String[string.length-1]);
   }
   
   public static List<String> toList(String[] str)
   {
	   List<String> list = new ArrayList<String>();
	   
	   for(String s : str)
	   {
		   list.add(s);
	   }
	   
	   return list;
	   
   }
	public static void main (String args [])
	
	{
		String [] string= {"er","rf","cd"};
		
		
		
		printArray(removeString(string,"rf"));
		
		
	}
}