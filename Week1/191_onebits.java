package leet;

public class onebits {
	public static int hammingWeight(int n) {
		int count=0;
		while(n!=0){
			if(1==(n & 1))
				count++;
//			Java也添加了一种“无符号”右移位运算符（>>>），它使用了“零扩展”：无论正负，都在高位插入0。这一运算符是C或C++没有的。 
			n=n>>>1;
		}
		return count;
	}
}
