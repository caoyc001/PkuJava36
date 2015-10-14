public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.trim().length()==0){
			return true;
		}
		char[] as=s.trim().toLowerCase().toCharArray();//ȥ�����߿ո񣬼���ѭ������
		int i=0;
		int j=as.length-1;
		//int j=s.trim().length()-1;ע��trim()������ʹ��
		
	//	char[] as=s.toLowerCase().toCharArray();//���Դ�Сд ignore cases
	   
		while(i<j){
			if(isNotAlphanumeric(as[i])){
				i++;
				continue;
			}
			if(isNotAlphanumeric(as[j])){
				j--;
				continue;
			}
			if(as[i]!=as[j]){
				return false;
			}
			i++;
			j--;
		}
		return true;

		
    }
	
	public boolean isNotAlphanumeric (char c){
		if((c>='a' && c<='z')|| (c>='A' && c<='Z')|| (c>='0' && c<='9')){
		    return false;
		}
		return true;
	}
}