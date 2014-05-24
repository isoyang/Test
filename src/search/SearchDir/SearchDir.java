package search.SearchDir;

import java.io.*;
import java.util.*;

import tool.process.Tackle;

public class SearchDir {
	
	
	
	static List<String> list = new ArrayList<String>();

	public static void search(String str)
	{
		
		File file = new File(str);
		
		if (file.isFile())
		{
		    list.add(file.getAbsolutePath());
		    
		    return;
		}
		else if (!(file.exists()))
		{
			System.out.println("NO FILE OR DIRECTORY EXITS!!!");
			
			return;
		}
		
		String [] FileCon = file.list();
		
		for(String string:FileCon)
		{
			
			search(str+"/"+string);
		}
	
	}
	
	public static List<String> getList()
	{
		return list;
	}
	
	public static void clearList()
	{
		list = null;
		
	    list = new ArrayList<String>();
	}
	
	public static void main (String[] args)
	{
		
		search("E:\\Test\\test_searchdir");
		
		List<String> lis=SearchDir.getList();
		 
		Tackle.printList(lis);
		
	}
	
	
}
