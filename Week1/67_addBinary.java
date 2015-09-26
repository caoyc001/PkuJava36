package leet;

import java.lang.String;;
public class addBinary {
public static String addBinary(String a, String b) {
		int alength=a.length();
		int blength=b.length();
		if(alength>blength)
		{
			return addBinary(b, a);
		}
		if(0==alength)
		{
			return b;
		}
		int addone=0;
		StringBuffer result=new StringBuffer();
		for(int i=0;i<alength;i++)
		{
			int ca= a.charAt(alength-1-i)-'0';
			int cb= b.charAt(blength-1-i)-'0';
			
			int addab=ca+cb+addone;
			//only two add 2,3
			//1+1=2->2+1=3
			//1+0 or 0+1 =1 -> 1+1=2
			result.insert(0, addab%2);
			addone=addab/2;
			
		}
		int last=blength-alength;
		while (1==addone && last!=0)
		{
			int cb= b.charAt(last-1)-'0';
			int addcb =cb+addone;
			result.insert(0, addcb%2);
			addone=addcb/2;
			last--;
		}
		if(last!=0)
		{
			String subb=b.substring(0, last);
			result.insert(0, subb);
		}
		return result.toString();
		
		
		 
    }


}
