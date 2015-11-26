public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> hashtable= new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(hashtable.containsKey(nums[i]))
				return true;
			hashtable.put(nums[i], 1);
		}
	
		return false;
    }