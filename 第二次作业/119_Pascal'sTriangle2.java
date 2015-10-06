//忽略了空间限制，单纯的调用了Pascal's Triangle的部分代码，占用空间为O(k2)
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
			//在循环的过程中，result的数值发生了改变，出现Wrong Answer
		/*	for(int j=0;j<i-1;j++){
				int temp=result.get(j)+result.get(j+1);
				result.set(j+1,temp);
			}*/
			i++;
			result.add(1);
		}
		return result;
    }