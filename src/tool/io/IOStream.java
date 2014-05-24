package tool.io;

import java.io.*;



public class IOStream extends OutputStream{

	OutputStream s1,s2;
	
	
	public IOStream(OutputStream stream1, OutputStream stream2) throws Exception
	{
		s1 = stream1;
		s2 = stream2;
	
	}
	@Override
	public void write(int b) throws IOException
	{
		s1.write(b);
		s2.write(b);
	}
}
