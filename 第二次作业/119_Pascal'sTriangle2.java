//�����˿ռ����ƣ������ĵ�����Pascal's Triangle�Ĳ��ִ��룬ռ�ÿռ�ΪO(k2)
/*public class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> front=new ArrayList<Integer>();
		front.add(1);
		int i=1;
		while(i<rowIndex+1){
			ArrayList<Integer> next=new ArrayList<Integer>();
			next.add(1);
			for(int j=0;j<i-1;j++){
				int temp=front.get(j)+front.get(j+1);
				next.add(temp);
			}
			next.add(1); 
			front=next;
			i++;
		}
		return front;
    }
}*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> result=new ArrayList<Integer>();
		if(rowIndex<0){
			return result;
		}
		result.add(1);
		int i=1;
 
		while(i<rowIndex+1){
		   	for(int j=result.size()-2;j>=0;j--){
				int temp=result.get(j)+result.get(j+1);
				result.set(j+1,temp);
			}
			//��ѭ���Ĺ����У�result����ֵ�����˸ı䣬����Wrong Answer
		/*	for(int j=0;j<i-1;j++){
				int temp=result.get(j)+result.get(j+1);
				result.set(j+1,temp);
			}*/
			i++;
			result.add(1);
		}
		return result;
    }