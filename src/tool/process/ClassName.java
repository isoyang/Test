package tool.process;

public class ClassName {

	public static String getClassN()
	{
		String classname = new Object()
		{
			public String getClassName() {  
	            String classname = this.getClass().getName();  
	            return classname.substring(0, classname.lastIndexOf('$'));  
	        }  
		
		}.getClassName();
		
		
		return classname;
	}
	
	public static void main(String args[])
	{
		System.out.println(getClassN());
	}
}
