public class Solution {
    public int romanToInt(String s) {
        int sum=0;
        int l=s.length();
        char[] arr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(arr[i]=='M'){
                sum +=1000;
                continue;
            }
            if(arr[i]=='D'){
                sum +=500;
                continue;
            }
            //�ַ�ΪCʱ��Ҫ�ж��Ҳ��Ƿ���D��M
            if(arr[i]=='C'){
                if(i+1==l){
                     sum +=100;
                     break;
                }
                if(arr[i+1]=='D'){
                    sum +=400;
                    ++i;
                }else if(arr[i+1]=='M'){
                    sum +=900;
                    ++i;
                }else{
                    sum +=100;
                }
                continue;
            }
            if(arr[i]=='L'){
                sum +=50;
                continue;
            }
            //�ַ�ΪXʱ��Ҫ�ж��Ҳ��Ƿ���L��C
            if(arr[i]=='X'){
                if(i+1==l){
                     sum +=10;
                     break;
                }
                if(arr[i+1]=='L'){
                    sum +=40;
                    ++i;
                }else if(arr[i+1]=='C'){
                    sum +=90;
                    ++i;
                }else{
                    sum +=10;
                }
                continue;
            }
            if(arr[i]=='V'){
                sum +=5;
                continue;
            }
            //�ַ�ΪIʱ��Ҫ�ж��Ҳ��Ƿ���V��X
            if(arr[i]=='I'){
                if(i+1==l){
                     sum +=1;
                     break;
                }
                if(arr[i+1]=='V'){
                    sum +=4;
                    ++i;
                }else if(arr[i+1]=='X'){
                    sum +=9;
                    ++i;
                }else{
                    sum +=1;
                }
                continue;
            }
        }
        return sum;
    }
}