public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int newlen=m+n-1;
        m--;
        n--;
        for(int i=newlen;i>0;i--)
        {
        	if(m<0 || n<0)
        		break;
        	if(nums1[m]>nums2[n])
        	{
        		nums1[newlen--]=nums1[m--];
        	}
        	else
        	{
        		nums1[newlen--]=nums2[n--];
        	}
        	
        }
        if(m<0)
        {
        	for(int i=n;i>=0;i--)
        	{
        		nums1[i]=nums2[i];
        	}
        }
    }
}