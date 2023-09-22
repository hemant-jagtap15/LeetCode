class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true; 
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;

        while(j < m) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
            if(i == n) return true;
        }
        return false;
    }
}