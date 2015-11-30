public class Solution {
    public boolean isPowerOfTwo(int n) {
        //提示位运算,,,,如果n不是2的幂，那么n和n-1的最高位肯定相同
        return n>0 && ((n&(n-1))==0);
        
        
        //直接除2运算
        /*if(n<=0){
            return false;
        }
        while(n!=1){
            if(n%2!=0){
                return false;
            }
            n=n/2;
        }
        return true;*/
    } 
}