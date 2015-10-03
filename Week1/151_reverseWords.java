package leet;

public class reverseWords {

	
	
public static String  reverseWords(String s) {
	int sindex=s.length()-1;
	String result="";
//	while(' '==s.charAt(sindex))
//	{
//		sindex--;
//	}
	int wordheadindex=-1;
	int wordendindex=-1;

//	wordendindex=sindex;
	while(sindex>=0){
		while ( sindex>-1 && ' '==s.charAt(sindex))
		{
			sindex--;
		}
		if(-1==sindex)
			break;
		wordendindex=sindex;
		while ( sindex>-1 && ' '!=s.charAt(sindex))
		{
			sindex--;
		}
		wordheadindex=sindex+1;
		result+=s.substring(wordheadindex, wordendindex+1);
		result+=" ";
	}
	if(result.length()>1)
		result=result.substring(0, result.length()-1);
	return result;
	
}
}
