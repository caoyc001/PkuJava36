public class Solution {
    public boolean isAnagram(String s, String t) {
        //����ֻʹ��contains��������Ӧ���ж��ַ�����
        if(s.trim().length()!=t.trim().length()){
            return false;
        }
        StringBuilder sbs=new StringBuilder(s);
        StringBuilder sbt=new StringBuilder(t);
        
        for(int i=0;i<sbs.length();i++){
            int temp=sbt.indexOf(sbs.charAt(i)+"");
            if(temp<0){
                return false;
            }else{
                sbt.deleteCharAt(temp);
                continue;
            }
            //forget temp=0
            /*if(temp>0){
                sbt.deleteCharAt(temp);
                continue;
            }else{
                return false;
            }*/
        }
        return true;
    }
}