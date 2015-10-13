public class Solution {
    public void remove(int[] nums,int add)
    {   
        int i,j,swap;
        for(i=add;i<nums.length-1;i++)
        {
            nums[i]=nums[i+1];
            
        }
       
       nums[nums.length-1]='\0';
    }
    public int removeElement(int[] nums, int val) {
        
        int length=nums.length,i;
        
        for(i=0;i<length;i++)
        {
            if(nums[i]==val)
            {remove(nums,i);
            length--;
            if(i!=nums.length-1)
            i--;
            }
        }
        return length;
        
    }
}