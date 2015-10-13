public class Solution { 
    public int[] twoSum(int[] nums, int target) {
        int []A=new int[2];
        int i,j;
        for(i=0;i<nums.length;i++)
         for(j=i+1;j<nums.length;j++)
          {
              if((nums[i]+nums[j])==target)
              {
                  A[0]=i+1;
                  A[1]=j+1;
                  return A;
              }
              
          }
        return A;
}
}