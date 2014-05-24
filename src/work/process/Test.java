package work.process;

import tool.io.IOFile;
import tool.process.Tackle;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String [] args)
	{
		
		String string = "(?i)(.*(Annual|Quarter|Interim|Financial)[^\"]+?(Report|Statement).*|.*[Qq][0-9].*|.*(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec).*|.*(click|FS|report|Financial|Download|Year\\sEnd|Quarter|High\\sQuality).*)";
		
		
		String empty = "";
		
		String str = "<a href=\"http://velaminerals.ca/wp-content/uploads/2012/11/2011-Q4-FS.pdf\"><strong   ></strong>click</a>";
		System.out.println("wAbcw".matches("(?i).*(cde|abc).*|.*efg.*"));
		
		System.out.println("test.pdf".matches("(?i).*pdf"));
		
		System.out.println(empty.matches(""));
		
		System.out.println(str.matches("(?i)<a\\shref=\"[^\"]+?\".*?>(.*?)</a>"));
		
		Pattern pattern = Pattern.compile("<a\\shref=\"([^\"]+?)\".*?>(.*?)</a>", Pattern.CASE_INSENSITIVE);
		
		Matcher mat = pattern.matcher(str);
		
		while(mat.find())
		{
			System.out.println(mat.group(1));
			System.out.println(mat.group(2));
			System.out.println("Test whether it is an empty string!!!");
			
			if(mat.group(2).matches(string))
			{
				System.out.println("true!!!!");
			}
		}
		
		
	}
}
