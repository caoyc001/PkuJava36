public class Solution {
    public List<List<Integer>> generate(int numRows) {
        //List<List<Integer>> result=new List<ArrayList<Integer>>();
        //Ƕ�׳�ʼ��ͬʱ��ʼ��������ԭ����
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
			//׼�����÷����㷨ֻ����list��ǰһ���ݣ���벿�ֺ�ǰ�벿����һ���ģ����ǻ����ӽ�ǰ�벿�������ʱ�䡣���������Щ���ӣ�����Ҫ�жϸ�����ż����δʵ��
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