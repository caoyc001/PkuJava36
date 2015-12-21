public class Solution {
    public int countPrimes(int n) {
        Boolean[] nums = new Boolean[n];
    	double dn=(double)n;
    	int last=(int)Math.sqrt(dn);
        for(int i=2; i<=last; i++) {  
            if(nums[i]==null) { 
            	nums[i]=false;
                for(int j=i*2; j<n; j+=i) {  
                    nums[j] = true;  
                }  
            }  
         }  
         int result=0;  
           
         for(int i=2; i<n; i++) {  
             if(nums[i] == null || nums[i]==false) 
             result++; 
         }  
         return result;

    }
}