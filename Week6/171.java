    public int titleToNumber(String s) {
		int result=0;
        char c[] =s.toCharArray();
        int len=s.length();
        if(len==0)
        	return result;
        for(int i=0;i<len;i++)
        {
        	int cur=(c[i]-'A'+1);
//        	result+= (c[i]-'A'-0)*Math.pow(10, len-i-1);
        	result=result*26+ cur;
        }
        return result; 
    }