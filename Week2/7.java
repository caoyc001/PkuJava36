//时间复杂度O(N)
public class Solution {
    public int reverse(int x) {
        int result=0;
		if(x>Integer.MAX_VALUE)
			return result;
		while(x!=0)  
        {  
			if(result>=214748365 ||result<=-214748365)
			{
				result=0;
				break;
			}
			if(result==214748364 && x>7)
			{
				result=0;
				break;
			}
			if(result==-214748364 && x<=-8)
			{
				result=0;
				break;
			}
			result = result*10 + x%10;  
            x /= 10;  
        }  
        return result;  
    }
}