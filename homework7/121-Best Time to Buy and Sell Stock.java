public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0 || prices.length==1){//fully considered
            return 0;
        }
        int maxDiff=0;
        int minPrice=prices[0];
        for(int i=0;i<prices.length;i++){
           /* if(prices[i]<minPrice){
                minPrice=prices[i];
            }*/
            minPrice=Math.min(prices[i],minPrice);
            /*if(maxDiff<(prices[i]-minPrice)){
                maxDiff=prices[i]-minPrice;
            }*/
            maxDiff=Math.max(prices[i]-minPrice,maxDiff);
        }
        //time limited
       /* for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if((prices[i]-prices[j])>maxDiff){
                    maxDiff=prices[i]-prices[j];
                }
            }
        }*/
        return maxDiff;
        //�ж�һ������Ƿ���ȷ����ʵ��ĿӦ�������������ͨ�����������,,,,,�ðɣ��������˸���
       /* if(prices==null || prices.length==0){
            return 0;
        }
        for(int i=prices.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(prices[j]>prices[j+1]){
                    int temp=prices[j+1];
                    prices[j+1]=prices[j];
                    prices[j]=temp;
                }
            }
        }
        return (prices[prices.length-1]-prices[0]);*/
        //ʹ��TreeSet��Ȼ���Զ����򣬵���Ҳ�������������
       /* Set<Integer> tree=new TreeSet<Integer>();
         for(int i=0;i<prices.length;i++){
        	 tree.add(prices[i]);
         }
         Object[] newPrices=tree.toArray();
         if(newPrices.length==1 || newPrices.length==0){
             return 0;
         }
         int max=(Integer) newPrices[newPrices.length-1];
         int min=(Integer)newPrices[0];
         return max-min;*/
         
         
    }
}