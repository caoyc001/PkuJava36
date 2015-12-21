public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // m=nums1.length;
        // n=nums2.length;
        int j=m-1;
        int k=n-1;
        for(int i=m+n-1;i>-1;i--){
            if(k>=0 && j>=0){
                if(nums1[j]<nums2[k]){
                    nums1[i]=nums2[k];
                    k--;
                }else{
                    nums1[i]=nums1[j];
                    j--;
                }
            }else if(k>=0){
                for(int z=k;z>=0;z--){
                    nums1[z]=nums2[z];
                }
                break;
            }else{
                break;
            }
            
        }
        
    }
}