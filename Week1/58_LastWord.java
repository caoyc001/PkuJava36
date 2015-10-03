package leet;

public class LastWord {
    public static int lengthOfLastWord(String s) {
        if(0==s.length())
            return 0;
        char c[]=s.toCharArray();
        int length=s.length();
        while (length>0 && ' '==c[length-1]) {
			
			length--;
		}
		if(0==length)
		    return 0;
		for(int i= length-1;i>=0;i--)
		{
			if(' '==c[i])
			{
			    return length-1-i;
			}
		}
		return length;
    }
}

