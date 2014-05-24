package pattern.regularExpression;

import tool.io.IOFile;
import tool.process.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestString {

	public static void main(String [] args)
	{
		
		List<String> list = new IOFile().readFile("E:\\test.txt");
		final  String  pt = "([Pp]roject|[Mm]ine|[Dd]eposit|[Pp]roperty)";
		
		//Tackle.printList(list);
		
		String string1 = "";
		
		for (String s : list)
		{
			string1 = string1 +" "+s.trim();
		}
		
		String [] tem= string1.split("\\.");
		
		Pattern pattern = Pattern.compile("(\\b[A-Z][a-z]*?\\b\\s)+\\b"+pt+"\\b");
	    List<String> list2 = new ArrayList<String>();
	    List<String> list3 = new ArrayList<String>();
	    String ss = "";
	    
		
	    for (String str : tem)
	    {
	    	if(str.matches(".*\\b"+pt+"\\b.*"))
	    	{
	    		str = str.trim();
	    		System.out.println(str);
	    		Matcher matcher = pattern.matcher(str);
	    		
	    		while(matcher.find())
	    		{
	    			 //System.out.println(matcher.group());
	    			 String temp = matcher.group();
	    			 temp = temp.replaceAll("\\s"+pt, "");
	    			 list3.add(temp);
	    		}
	    		
	    		   //list3.add("one search finished!!!");
	    																	
	    				
	    	    
	    	    Tackle.printList(list3);
	    	    
	    	    
	    	 }
	    	
	     }	
		    
		
	   
	}
}
