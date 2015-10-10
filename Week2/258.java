//可以用数字根公式
//dr(n)=1+((n-1) mod 9)
//https://en.wikipedia.org/wiki/Digital_root
//时间复杂度O(1)
public class Solution {
    public int addDigits(int num) {
        if(num<9)
			return num;
        int result= num%9;
        return 0==result?9:result;
    }
}