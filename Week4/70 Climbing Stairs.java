public class Solution {
    public int climbStairs(int n) {
        int f1=1;
        int f2=2;
        if(0==n)
            return 0;
        if(1==n)
            return 1;
        if(2==n)
            return 2;
        int fab=0;
        for(int i=3;i<=n;i++)
        {
            fab=f1+f2;
            f1=f2;
            f2=fab;
        }
        return fab;
    }
}