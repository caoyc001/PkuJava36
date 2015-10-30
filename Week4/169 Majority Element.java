//算法课，芯片测试思想
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==1)
    		return nums[0];
    	int element=nums[0];
    	int count=1;
    	for(int i=1;i<nums.length;i++)
    	{
    		if(nums[i]!=element)
    		{
    			count--;
    			if(count==0)
    			{
    				element=nums[++i];
    				count=1;
    			}
    		}
    		else {
				count++;
			}
    	}
    	return element;
    }
}