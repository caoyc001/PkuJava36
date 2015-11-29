public class Solution {
 public int removeDuplicates(int[] A) {
    if(A.length ==0){
      return 0;
    }
    int count=1;
    for(int i=1; i<A.length; ++i){
      if(A[i] != A[i-1]){         
A[count]=A[i];
        count++;
      }
    }
    return count;
  }
}