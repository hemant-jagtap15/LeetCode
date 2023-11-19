class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int cnt = 0;
        int len = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int i = 0;
        
        while(i < len){
           if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
               i++;
               cnt++;
           } else {
               break;
           }
        }
        if(cnt == 0) return -1;
        return s1.length() + s2.length() + s3.length() - (3 * cnt);
    }
}