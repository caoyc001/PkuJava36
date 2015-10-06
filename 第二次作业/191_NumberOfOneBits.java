public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
		int count=0;
		//没做前在群里看到用&运算，先入为主，只想到了&方法
       for(int i=0;i<32;i++){
			if(((n>>i)&1)==1){//通过n的右移与1做与运算，判断最后一位是否为1
				count++;
			}
	   } 
	   return count;
    }
}