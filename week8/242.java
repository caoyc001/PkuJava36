
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
 
        char[] cs = s.toCharArray();
 
        for(char c : cs) {
            int x = c - 'a';
            map[x] += 1;
        }
 
        cs = t.toCharArray();
 
        for(char c : cs) {
            int x = c - 'a';
            if(map[x] == 0) {
                return false;
            }
            map[x] -= 1;
        }
 
        for(int x : map) {
            if(x != 0) {
                return false;
            }
        }
        return true;
    }
}