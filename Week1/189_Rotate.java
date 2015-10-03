package leet;

import com.sun.tools.doclets.formats.html.resources.standard;

public class Rotate {
	public static void rotate(int[] nums, int k){
		int length=nums.length;
		while (k>length)
			k-=length;
		if(length>1)
		{
			rotateTotal(nums,0,length-1-k);
			rotateTotal(nums,length-k,length-1);
			rotateTotal(nums,0,length-1);
		}
		
	}
	private static void rotateTotal(int[] nums,int first,int last) {
		while(first<last)
		{
			int tmp=nums[first];
			nums[first]=nums[last];
			nums[last]=tmp;
			first++;
			last--;
		}
//		if(first>=last)
//			return;
//		int mid=(last-first)/2;
//		for(int i=0;i<=mid;i++)
//		{
//			int tmp=nums[first+i];
//			nums[first+i]=nums[last-i];
//			nums[last-i]=tmp;
//		}
	}
}
