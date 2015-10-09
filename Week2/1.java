//时间复杂度O(n)

public int[] twoSum(int[] nums, int target) {
		 
//		 	对于 HashSet 而言，它是基于 HashMap 实现的，HashSet 底层采用 HashMap 来保存所有元素
//		 	Hashtable 中的方法是同步的，而HashMap中的方法在缺省情况下是非同步的。
//		 	在多线程并发的环境下，可以直接使用Hashtable，但是要使用HashMap的话就要自己增加同步处理了。
	        Hashtable<Integer, Integer> hashtable=new Hashtable<Integer, Integer>();
	        int[] result=new int[2];
	        for(int i=0;i<nums.length;i++)
	        {
	        	if(null==hashtable.get(nums[i]))
	        	{
	        		hashtable.put(target-nums[i], i);
	        	}
	        	else {
	        		result[0]=hashtable.get(nums[i])+1;
		        	result[1]=i+1;
		        	break;
	        	}	
	        }
	        return result;
	    
	 }