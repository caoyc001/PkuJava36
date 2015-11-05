public class Solution {
    public int climbStairs(int n) {
        //T(n)=T(n-1)+T(n-2)
        int s1=1;
        int s2=2;
        int s=0;
        int temp=0;
        if(n==1){
            return s1;
        }
        if(n==2){
            return s2;
        }
        for(int i=3;i<=n;i++){
            s=s1+s2;
            s1=s2;
            s2=s;
        }
        return s;
    }
}