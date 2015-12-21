public class Solution {
     public int trailingZeroes(int n) {
        // int remainder =n%5;
        int times=0;
        while(n>=5)
        {
            n=n/5;
            times+=n;
        }
        return times;
        
    }

}