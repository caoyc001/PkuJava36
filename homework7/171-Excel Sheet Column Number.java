public class Solution {
    public int titleToNumber(String s) {
        
        //26进制转十进制
        if(s==null || s.trim().length()==0){
            return 0;
        }
        int sum=0;
        char[] arr=s.toCharArray();
        int length=arr.length;
        for(int i=0;i<length;i++){
        //	sum +=((int)arr[i]-64)*(Math.pow(26, length-1-i));
            sum +=(arr[i]-'A'+1)*(Math.pow(26, length-1-i));
        }
        return sum;
    }
}