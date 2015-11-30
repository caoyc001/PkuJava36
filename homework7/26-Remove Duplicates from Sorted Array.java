public class Solution {
    public int removeDuplicates(int[] nums) {
        int length=0;
        if(nums==null){
            return 0;
        }
       /* if(nums.length==1){
            return 1;
        }*/
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }else{
                length++;
                nums[length]=nums[i+1];
            }
        }
        return length+1;
    }
}