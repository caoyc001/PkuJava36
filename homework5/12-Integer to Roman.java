public class Solution {
    public String intToRoman(int num) {
        String[][] roman={
            {"I","II","III","IV","V","VI","VII","VIII","IX"},
            {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"M","MM","MMM"}
        };
        
        //"nullnullnullI"
      //  String[] str=new String[4];
         String[] str=new String[]{"","","",""};
        int count=0;
        while(num!=0){
            int r=num%10;
            num=num/10;
            if(r!=0){
                str[count]=roman[count][r-1];
            }
            count++;
        }
        return str[3]+str[2]+str[1]+str[0];
    }
}