package pattern.regularExpression;

import tool.io.*;
import tool.process.Tackle;

import java.util.*;

public class TestStringCon {
	
	public static void main(String [] args)
	{
		List<String> list = new IOFile().readFile("E:\\test.txt");
		
		String str = "";
		
		//Tackle.printList(list);
		
		for (String string : list)
		{
			string = string.trim();
			str=str+string;
		}
		
		System.out.println(str);
		
		String [] temp = str.split(" ");
		
		Tackle.printArray(temp);
		
	}

	
}
