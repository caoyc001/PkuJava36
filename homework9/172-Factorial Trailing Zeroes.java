public class Solution {
    public int trailingZeroes(int n) {
        
       if(n<1) return 0;   
        int c = 0;   
           
        while(n/5 != 0) {    
            n /= 5;   
            c += n;   
        }   
           
        return c;
        
        
        //Time Limit Exceeded 看不出区别啊，一个是向上走，一个是向下走
       /* int k=5;
        int sum=0;
        while(n>=k){
            sum +=n/k;
            k=k*5;
        }
        return sum;*/
        
        //为了pass，不择手段~~~~
        /*if(n==0){
            return 0;
        }
        //sum=n/5 + n/25 +n/125
        int sum=0;
        double k=Math.log(n)/Math.log(5);
        for(int i=0;i<(int)k;i++){
            int j=(int)Math.pow(5,i+1);
            sum +=n/j;
        }
        return sum;*/
        
        
        
        //Line 3: java.lang.OutOfMemoryError: Java heap space  内存溢出
        /*int[] a=new int[n+1];
        a[0]=0;
        for(int i=1;i<=n;i++){
            if(i%5!=0){
                a[i]=a[i-1];
            }else{
                int count=1;
                int k=i/5;
                while(k%5==0){
                    count =+1;
                    k=k/5;
                }
                a[i]=a[i-1]+count;
            }
        }
        return a[n];*/
       // return n/5;//too young too simple....
    }
}