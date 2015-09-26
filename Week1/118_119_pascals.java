package leet;

import java.util.ArrayList;
import java.util.List;

public class pascals {
public static List<Integer> getRow(int rowIndex) {
	List<Integer> result=new ArrayList<Integer>();
	if (0==rowIndex)
		return result;
	result.add(1);
	if (1==rowIndex)
	{
		return result;
	}
	for(int i=2;i<=rowIndex;i++)
	{
		result.add(1);
	}
        for(int i=2;i<=rowIndex;i++)
        {
        	int mid=i/2;
        	int last=result.get(mid-1);
        	for(int j=1;j<mid;j++)
        	{
        		result.set(i-1-j, result.get(j-1)+result.get(j));        		
        	}
        	if(1==(i & 1))
        	{
//        		result.add(last*2);
        		result.set(mid, last*2);
        	}
        	for(int k=1;k<mid;k++)
        	{
        		result.set(k, result.get(i-k-1));
        	}
        }
//    	int mid=rowIndex/2;
//        for(int i=mid-1;i>=0;i--)
//        {
//        	result.add(result.get(i));
//        }
    return result;
    }
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if (0==numRows)
		{
			return result;
		}
		List<Integer> one=new ArrayList<Integer>();
		one.add(1);
		result.add(one);
		List<Integer> preList=one;
		if(1== numRows)
		{			
			return result;			
		}
		
		for(int i=2;i<=numRows;i++)
		{
			List<Integer> curList=new ArrayList<Integer>();
			curList.add(1);
			for(int j=1;j<i-1;j++)
			{
				curList.add(preList.get(j-1)+preList.get(j));
			}
			curList.add(1);
			
			result.add(curList);
			preList=curList;
			
		}
		
		return result;
	}
}
