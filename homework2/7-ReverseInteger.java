public class Solution {
    public int reverse(int x) {
        
        ////////////////String.charAt()///////////////
       /* String sx=x<0?x+"":"+"+x;
        String sr="";
        for(int i=sx.length()-1;i>0;i--){
            sr +=sx.charAt(i);
        }
        //Line 11: java.lang.NumberFormatException: For input string: "9646324351" input��1534236469��
        //��Ҫ����int�ͣ����ѳ���int�����ֵ 
         if(Long.parseLong(sr)>Integer.MAX_VALUE){
            return 0;
        }
        
        if(x<0){
        	return -Integer.parseInt(sr);
        }
        return Integer.parseInt(sr);
    }  */
    //////////////////StringBuilder.reverse()////////////
      //  String sx=""+Math.abs(x);  ȥ��Сֵʱ����
       /* String sx="";
        if(x==Integer.MIN_VALUE){
            sx +=Math.abs(x+1);
        }else{
            sx +=Math.abs(x);
        }
        StringBuilder sb=new StringBuilder(sx).reverse();
        String sr=sb.toString();
        if(Long.parseLong(sr)>Integer.MAX_VALUE){
            return 0;
        }
        
        if(x<0){
        	return -Integer.parseInt(sr);
        }
        return Integer.parseInt(sr);*/
        String sx="";
        if(x==Integer.MIN_VALUE){
            sx +=Math.abs(x+1);
        }else{
            sx +=Math.abs(x);
        }
        //Stack stack=new Stack();            stack�д����Ϊ���󣬲�����ת��
		 
		Stack<Character> stack=new Stack<Character>();
		String sr="";
		for(int i=0;i<sx.length();i++){
			stack.push(sx.charAt(i));
		}
		for(int i=0;i<sx.length();i++){
			sr +=stack.pop();
		}
		if(Long.parseLong(sr)>Integer.MAX_VALUE){
            return 0;
        }
        
        if(x<0){
        	return -Integer.parseInt(sr);
        }
        return Integer.parseInt(sr);
    }
}