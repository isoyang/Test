/*this file is to figure out URLs of companies which can not be found out by using filtering methods based on comparison
 * 
 *of strings between trimmed URL and trimmed companies names.
 *
 *Input: withoutwebsite.txt   withwebsite.txt
 *Output: comparewebsite.txt
 *
 *list - company list which have no hits after employing comparison methods.
 *list1 - URL list produced by default method which extract the top ranking URL from results.
 *list2 - URL list which contains companies names which have no place in comparison methods and ranking number in the original company name list.
 * 
 * 
*/
package search.web;
import java.util.*;
import tool.io.IOFile;
import tool.process.Tackle;


public class CompareMethodTest {

	public static void main(String [] args)
	{
		List<String> list = new IOFile().readFile("/home/lamb/withoutwebsite.txt");
		List<String> list1 = new IOFile().readFile("/home/lamb/website.txt");
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new IOFile().readFile("/home/lamb/company.txt");
		List<String> list4 = new ArrayList<String>();
		String [] key = Tackle.getKey(list);
		
		for (int i = 0 ; i < key.length ; i++)
		{
			String str1 = list1.get(Integer.parseInt(key[i])-1);
			String str2 = list3.get(i);
			list2.add(str1+" "+key[i]);
			list4.add(str1+"**"+Tackle.trimURL(str1)+"**"+Tackle.trimCompany(str2)+"**"+str2+"  "+key[i]);
		}
		
		new IOFile().writeFile(list2, "/home/lamb/comparewebsite.txt", false);
		new IOFile().writeFile(Tackle.addLine(list4), "/home/lamb/comparewebsitewithnames.txt", false);
		
		Tackle.printList(list2);
		Tackle.printList(list4);
	}
}
