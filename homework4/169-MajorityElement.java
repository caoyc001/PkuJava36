public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        //T(n)=O(n)
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                //Ë³ĞòºÜÖØÒª£¡£¡£¡
                int x=map.get(nums[i]);
                x++;
                if(x>=(nums.length)/2+1){
                    return nums[i];
                }
                map.put(nums[i],x);
            }else{
                map.put(nums[i],1);
            }
        }
        
        /*for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            if(entry.getValue()>=(nums.length)/2+1){
                return entry.getKey();
            }
        }*/
		return 0;
   }
}