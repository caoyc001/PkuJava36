package leet;

public class sortColors {
	public static void sortColors(int[] nums) {
        int n=nums.length;
        if (n<2)
            return;
		int first=0;
		int last=nums.length-1;
		
		while (0==nums[first] &&first<last)
			first++;	
		while (2==nums[last] &&first<last)
			last--;
		if(first>=last)
		    return;
		int i=first;
		while (first!=last && i<=last)
		{
			if(2==nums[i])
			{
			    int tmp=nums[i];
				nums[i]=nums[last];
				nums[last]=tmp;
				last--;	
			}
			else if (0== nums[i]) {
			    
				int tmp=nums[first];
				nums[first]=nums[i];
				nums[i]=tmp;
				first++;
				i++;
				
			}
			else {
				i++;
			}
		}
    }
}
