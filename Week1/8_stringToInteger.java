package leet;

public class stringToInteger {
	    public int myAtoi(String str) {
	        if(0==str.length())
	            return 0;
	        char[] c = str.toCharArray();
			int num = 0;
			Boolean flag=true;
			while(c[num] == ' ')
			    num++;
			if(c[num] == '-')
			{
				flag=false;
				num+=1;
			}
			else if(c[num] == '+')
			{
//				flag=true;
				num+=1;
			}
//			else if(c[0] > '9' || c[0] < '0')
//			else {
////				num += pow(10, c.length) * (c[0] - '0');
//			}
//			ArrayList<Integer> a=new ArrayList<Integer>();
			long  result=0;
			for(int i = num; i < c.length; i++)
			{
				if(c[i] >= '0' && c[i] <= '9')
				{
					result*=10;
					result+=c[i] - '0';
//					a.add(c[i] - '0');
	                if(result>0x7fffffff)
						break;
				}
				else {
					break;
				}
			}
			if(!flag)
				result*=-1;
			if(result <= 0x7fffffff && result >= 0x80000000)	
			    return (int)result ;
			else if (result > 0x7fffffff)
			    return 0x7fffffff;
			else
			    return 0x80000000;
			    
	    }
}


