package study.core;

public class TestMemory {
	
	public static void increment(int i)
	{
		i++;
		
		System.out.println(i);
	}
	
	public static void main (String args[])
	{
		int i = 10;
		
		System.out.println(i);
		
        i = i + 1;
		
		System.out.println(i);
	}

}
