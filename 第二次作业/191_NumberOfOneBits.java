public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
		int count=0;
		//û��ǰ��Ⱥ�￴����&���㣬����Ϊ����ֻ�뵽��&����
       for(int i=0;i<32;i++){
			if(((n>>i)&1)==1){//ͨ��n��������1�������㣬�ж����һλ�Ƿ�Ϊ1
				count++;
			}
	   } 
	   return count;
    }
}