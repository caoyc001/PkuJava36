public class Solution {
    public int countPrimes(int n) {
       //remember???�����װ�~~~
        if(n==0 || n==1){
            return 0;
        }
        int count=0;
        boolean[] a=new boolean[n];
        a[0]=false;
        a[1]=false;
        for(int i=2;i<n;i++){
            a[i]=true;
        }
        
        //��ʾ�㷨
        for(int i=2;i*i<n;i++){
            if(!a[i]){
                continue;
            }else{
                //С�Ż���i*j�������ظ���ֵ
                /*for(int j=2;i*j<n;j++){
                    a[i*j]=false;
                }*/
                for(int j=i*i;j<n;j+=i){
                    a[j]=false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]){
                count +=1;
            }
        }
        return count;
        //Time Limit Exceeded
       /* int count=0;
        for(int i=2;i<n;i++){
        	boolean flag=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                	flag=false;
                    break;
                } 
            }
            if(flag==true){
            	count +=1;
            }
        }
        return count;*/
    } 
    
  
}