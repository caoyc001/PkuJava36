//头指针和尾指针
//时间复杂度O(N)
public class Solution {
    boolean ignorechar(char c)
	{
		return c<'0'|(c>'9'&c<'A')|(c>'Z'&c<'a')|c>'z';
	}
    public boolean isPalindrome(String s) {
        char[] ss=s.toCharArray();
		int i=0,j=ss.length-1;
		while (i<j)
		{			
// 			while(i<j && ss[i]<'A' || (ss[i]>'Z' && ss[i]<'a') || ss[i]>'z')
            while(i<j && ignorechar(ss[i]))
				i++;
// 			while(i<j && ss[j]<'A' || (ss[j]>'Z' && ss[j]<'a') || ss[j]>'z')
            while(i<j && ignorechar(ss[j]))
				j--;
			if(i>=j)
				break;
			if(ss[i]!=ss[j] && Math.abs(ss[i]-ss[j])!=32)
			{
				return false;
			}
			else {
				i++;
				j--;
			}
		}
		return true;
    }
}