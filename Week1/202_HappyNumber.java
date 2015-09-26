package leet;

public class HappyNumber {
	public static boolean isHappy(int n) {
		while (n!=1)
		{
			n=happyit(n);
			if(n<10)
				break;
		}
		if(n!=1)
			return false;
		else {
			return true;
		}
		
	}
	private  static int happyit(int n) {
		int result=0;
		while (n!=0)
		{
			int i=n%10;
			n/=10;
			result+=i*i;
		}
		return result;
		
	}

}
