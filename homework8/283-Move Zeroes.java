public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }
        for(int i=nums.length-1;i>-1;i--){
            if(nums[i]==0){
                int prev=i;
                while(prev<nums.length-1 && nums[prev+1]!=0){
                        nums[prev]=nums[++prev];
                        nums[prev]=0;
                }
            }else{
                continue;
            }
        }
    }
}