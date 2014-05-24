package test.re;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchString {

	public static void main(String [] args) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		Scanner scan = new Scanner(new FileInputStream(new File("C:\\Users\\YANG\\Desktop\\truegold.txt")));
		
		while(scan.hasNext())
		{
			sb.append(scan.nextLine());
		}
		scan.close();
		
		String string = sb.toString();
		
		string = string.replaceAll("\\\\", "");
		
		
		// regex
		
		String pat = "<a\\s+href=\\s*(\"([^\"]*)\").*?>";
		
		String pat1 = "(.*([Aa]nnual|[Qq]uarter|[Ii]nterim|[Ff]inancial|[Qq]uarterly)[^\"]+?([Rr]eport|[Rr]eports|[Ss]tatement|[Ss]tatements).*|.*[Qq][0-9].*|.*FS.*)";
		
		Pattern p = Pattern.compile(pat, Pattern.CASE_INSENSITIVE);
		
		Matcher m = p.matcher(string);
		
		while(m.find())
		{
			String url = m.group(2);
			
			if(url.endsWith(".pdf"))
			{
				//System.out.println(url);
				
				String reg = "<a\\s+href=\\s*\""+url+"\".*?>(?:<.*?>)*(.*?(?!<a).*?)</a>";
				
				Pattern pattern1 = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
				Matcher matcher1 = pattern1.matcher(string);
				while(matcher1.find())
				{
					String mat = matcher1.group(1);
					if(mat.matches(pat1))
					System.out.println(mat);
				}
			}
			
		}
		
		// check ?
		
		String wenhao = "Document?download";
		
		String xixi = ".*?\\?.*?";
		
		if(wenhao.matches(xixi))
		{
			System.out.println("true!!");
		}
	}
}
