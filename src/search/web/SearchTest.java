/* This file is to apply search method on original company list. And the companies will be split into two parts:
 * those with website and without website.
 *
 * 
 * Input: company.txt
 * Output: withwebsite.txt  withoutwebsite.txt
 * 
 * each record in both txt files contains 2 components:
 * 
 * withwebsite.txt: URl + ranking number in company list
 * 
 * withoutwebsite.txt: company name + ranking number in company list.
 * 
 */

package search.web;
import java.util.*;

import tool.io.IOFile;

import tool.process.Tackle;


public class SearchTest {

	public static void main(String [] args)
	{
		int n = 10;
		List<String> list = IOFile.readFile("C:\\Users\\YANG\\Desktop\\FileIE\\remain.txt");
		
		List<String> finalList = new ArrayList<String>();
		List<String> noUrlList = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++)
		{
			Searcher sr = new Searcher(n);
			
			
			String [] temp  = list.get(i).split("  ");
			String string = temp[0];
			String ticker = temp[1];
			String key = temp[2];
			String trimstr = Tackle.trimCompany(string);
			
			sr.search(string);
			String [] url = sr.getStringarray();
			
			int pointer = 0 ;
			
			for (int j = 0;j < url.length;j++)
			{
				
				if(Tackle.compareArray(Tackle.trimURL(url[j]), trimstr)==Tackle.trimURL(url[j]).length())
		
				{
					finalList.add(url[j]+"  "+ticker+"  "+key);
					pointer = 1;
					System.out.println(url[j]);										
					break;
				}
		
			}
			
			if(pointer==0)
			{
				noUrlList.add(string+"  "+ticker+"  "+key);
				System.out.println(string);
			}
			
			sr=null;
			key=null;
			ticker = null;
			string = null;
			url=null;
				
		}	
		
		IOFile.writeFile(finalList,"C:\\Users\\YANG\\Desktop\\FileIE\\remainwebsite.txt",false);
		
		IOFile.writeFile(noUrlList, "C:\\Users\\YANG\\Desktop\\FileIE\\remainnowebsite.txt",false);
		
	}
}
