package tool.filter;

import java.util.*;

public class Filter {
	
	
	
	private static String core = "[Oo]ur|[Tt]he|[Ee]ach|[Uu]nderground|[Aa]ll|[Gg]ross|[Cc]urrent|[Ww]as|[Tt]hese|[Tt]his|[Ff]ormer|[Oo]ptimized|[Ss]uspending|[Ss]urface|[Oo]pen|[Ff]ollowing";
	private static String reg = "("+core+")";
	private static String reg1 = ".*"+reg+".*";
	
	public static List<String> filterWord(List<String> list)
	{
		List<String> newlist = new ArrayList<String>();
		for (int i = 0 ; i < list.size() ; i++)
		{
			String string = list.get(i);
			if(string.matches(core))
			{
				continue;
			}
			else if(string.matches(reg1))
			{
				string = string.replaceAll(reg+"\\s", "");
				newlist.add(string);
			}
			else
			{
				newlist.add(string);
			}
				
		}
		
		
		return newlist;
	}
	
	public static void setReg(String str)
	{
	        reg = str;
	}
	
	public static void addReg(String str)
	{
		reg = "(" + core+"|["+str.substring(0,1).toUpperCase()+str.substring(0,1)+str.substring(1)+")";
	}
	
	public static String getRge()
	{
		return reg;
	}
}

