//判断2可以用位运算
//判断5只需要取末尾
//开始是判断3用各位之和，但是这样不能判断剩下的约数
//因为是除法，时间复杂度O(N)
public class Solution {
    public boolean testThree(int num)
	{
	    while (num%3==0)
		{
			num/=3;
		}
		if(1==num)
			return true;
		return false;
// 		int three=0;
// 		while (num!=0){
//         	three+=num%10;
//         	num/=10;
// 		}
// 		if(three>10)
// 		{
// 			return testThree(three);
// 		}

// 		if(3==three || 6==three ||9==three)
// 		{
// 			return true;
// 		}
// 		else {
// 			return false;
// 		}
		
	}
	
    public boolean isUgly(int num) {
        if(num<=0)
			return false;
        while (0==(num&1))
        {
        	num=num>>1;
		}
        while(0==num%10 || 5==num%10)
        {
        		num/=5;
        }
        if(num==1)
        	return true;
        if(!testThree(num))
        	return false;
        return true;
    }
}