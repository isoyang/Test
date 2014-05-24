package tool.process;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import tool.io.*;


public class ToLog {

	public static void generateLog(Object object) 
	{
		try
		{
			File log = new File("E:\\Test\\Log\\"+object.getClass().getName()+".txt");
			if(!(log.exists()))
			{
				log.createNewFile();
			}
			PrintStream original = System.out;
			FileOutputStream  ps = new FileOutputStream(log,false);
			IOStream both = new IOStream(original,new PrintStream(ps));
			System.setOut(new PrintStream(both));
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			System.out.print("******************************************This Program starts at     ");
			System.out.print(df.format(new Date()));
			System.out.print("   **************************************************");
			System.out.println("");
		}
		
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		
		
	}
	
	public static void main(String args[])
	{
		generateLog(new ToLog());
		System.out.println("This is text file");
		System.out.println("Is it Right??");
	}
}
