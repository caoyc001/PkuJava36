public class Solution {
    public List<List<Integer>> generate(int numRows) {
        //List<List<Integer>> result=new List<ArrayList<Integer>>();
        //嵌套初始化同时初始化？？？原理？？
       // ArrayList<List<Integer>> result=new ArrayList<ArrayList<Integer>>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(numRows==0){
            return result;
        }
		List<Integer> front=new ArrayList<Integer>();
		front.add(1);
		result.add(front);
		int i=1;
		while(i<numRows){
			ArrayList<Integer> next=new ArrayList<Integer>();
			next.add(1);
			//准备采用分治算法只计算list的前一部份，后半部分和前半部分是一样的，但是会增加将前半部分逆序的时间。计算过程有些复杂，还需要判断个数奇偶，暂未实现
		/*	int upper=Math.ceil((i-1)/2);
			for(int j=0;j<upper;j++){
				int temp=front.get(j)+front.get(j+1);
				next.add(temp);
			}
			for(int k=upper-1;k>0;k--){
				next.add(next.get(k);
			}*/
			for(int j=0;j<i-1;j++){
				int temp=front.get(j)+front.get(j+1);
				next.add(temp);
			}
			next.add(1);
			result.add(next);
			front=next;
			i++;
		}
		return result;
    }
}