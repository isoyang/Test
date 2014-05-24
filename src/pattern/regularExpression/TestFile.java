package pattern.regularExpression;

import java.io.*;
import tool.process.*;


public class TestFile {

	public static void main(String args[])
	{
       File file = new File("E:\\Test\\AnnualREport2008.pdf");
		
	   String string [] = file.list();
	
	   Tackle.printArray(string);
	}
}
