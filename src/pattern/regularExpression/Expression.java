package pattern.regularExpression;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Expression 

{
    public static void main(String []args)
    {
    	// new
    	String str1 = "<a href=\"http://ucore.com/documents/Ucore_Q1_2013_FS.pdf\" target=\"_blank\"><strong>Mar 31, 2013</strong> &#8211; Ucore Rare Metals Inc. Unaudited Financial Statement</a>";
    	
    	// standard
    	
    	String str2=  "<a href=\"http://truegoldmining.com/sites/default/files/TGM_-_FS_-_Dec_31_2012_-_Final_043013.pdf\" type=\"application/pdf; length=552997\" title=\"TGM_-_FS_-_Dec_31_2012_-_Final_043013.pdf\">Financial Statements </a> <a href=\"\"></a>";
    	
    	String reg = "<a\\s+href=\\s*(\"([^\"]*?)\").*?>";
    	
    	String reg2 = "(.*([Aa]nnual|[Qq]uarter|[Ii]nterim|[Ff]inancial|[Qq]uarterly)\\s?([Rr]eport|[Rr]eports|[Ss]tatement|[Ss]tatements).*|.*[Qq][0-9].*|.*FS.*)";
    	
    	Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
    			
    	Matcher matcher1 = pattern.matcher(str1);
    	
    	Matcher matcher2 = pattern.matcher(str2);
    	
    	while(matcher1.find())
    	{
    		String string = matcher1.group(2);
    		System.out.println(string);
    		
    		String reg1 = "<a\\s+href=\\s*\""+string+"\"[^>]*>(.*?(?!<a).*?)</a>";
    		
    		Pattern p1 = Pattern.compile(reg1, Pattern.CASE_INSENSITIVE);
    		Matcher m1 = p1.matcher(str1);
    		
    		if(m1.find())
    		{
    			System.out.println(m1.group(1));
    		}
    	}
    	
    	while(matcher2.find()) 
    	{
    		System.out.println(matcher2.group(2));
    	}
    	// another test
    	String regg = "^<a\\s+href=\\s*(\"([^\"]*)\")[^>]*>(?:<.*?>)*(.*?(?!<a).*?)</a>.*?$";
    			
        String test = "<a href= \"test\" title=><img src=\"\" testheresdgfvvsdfvsdfv ><Strong>Marchhei hei</a><a href></a>" ;
        
        System.out.println(test.matches(regg));
        
        Pattern delete = Pattern.compile(regg,Pattern.CASE_INSENSITIVE);
        
        Matcher del = delete.matcher(test);
        
        
   
        if(del.find())
        {
        	System.out.println(del.group(3));
        }
        
        // another
        
        String exc = "http://www.xtierra.ca/pdf/\\XAG (RMP) F.pdf";
        
        System.out.println(exc);
      
        exc = exc.replaceAll("\\\\", "");
        
        
        System.out.println(exc);
        
        
        // another
        
        String test1 = "<a href=\"http://truegoldmining.com/sites/default/files/rvs-2012-07-31-fs.pdf\" type=\"application/pdf; length=901465\" title=\"rvs-2012-07-31-fs.pdf\">Financial Statements for Q3 2012</a></span></li><li><span class=\"file\"><img class=\"file-icon\" alt=\"\" title=\"application/pdf\" src=\"/modules/file/icons/application-pdf.png\" /> <a href=\"http://truegoldmining.com/sites/default/files/rvs-2012-07-31-mda.pdf\" type=\"application/pdf; length=497851\" title=\"rvs-2012-07-31-mda.pdf\"> Jul 31, 2012 Management Discussion and Analysis for Q3 2012</a></span></li></ul></div></div>";
        
        Matcher matcher3 = pattern.matcher(test1);
        
        while(matcher3.find())
        {
        	String gg = matcher3.group(2);
        	System.out.println(gg);
        	
        	String reg1 = "<a\\s+href=\\s*\""+gg+"\".*?>(?:<.*?>)*(.*?(?!<a).*?)</a>";
        	System.out.println(reg1);
        	Pattern delete1 = Pattern.compile(reg1, Pattern.CASE_INSENSITIVE);
        	Matcher matcher4 = delete1.matcher(test1);
        	
        	if(matcher4.find())
        	{
        		System.out.println(matcher4.group(1));
        		
        		if(matcher4.group(1).matches(reg2))
        		{
        			System.out.println("Trure");
        		}
        	}
        }
        
        // another one 
        
        String ss = "[12][0-9]{3}[^0-9]*";
        System.out.println("Begin:");
        System.out.println("20012345".matches(ss));
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
