public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
       //set.cntains()的效率？？？？
       /* for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }*/
        //直接求长度
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()!=nums.length){
            return true;
        }
        return false;
    }
}