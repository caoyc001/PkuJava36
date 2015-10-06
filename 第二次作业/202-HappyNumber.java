public class Solution {
    public boolean isHappy(int n) {
        int sum=0;
      //  ArrayList<int> arr=new ArrayList<int>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        //因为超时问题，尝试使用HashSet，后发现并没有关系
     //  Set<Integer> set=new HashSet<Integer>();
     //  set.add(n);
		arr.add(n);
		//while(1)
		while(true){
		//	int a=n%10;
		//	sum +=a*a;
			sum +=Math.pow(n%10,2);
			n=n/10;
			if(n==0){
				//happy number
				if(sum==1){
					return true;
				}
				//unhappy number
			/*	if(set.contains(sum)){
				    return false;
				}*/
				if(arr.contains(sum)){
				    return false;
				}
			/*	for(int b:arr){
					if(b==sum){
						return false;
					}
				}*/
				n=sum;
				sum=0;//超时问题的出现并非因为Arraylist或HashMap,而是因为sum最后没有置零啊，，，，
				//set.add(n);
				arr.add(n);
			}
		}
    }
}