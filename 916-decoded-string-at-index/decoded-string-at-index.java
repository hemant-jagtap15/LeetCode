class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long currLength = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                currLength *= ch - '0';
            } else {
                currLength++;
            }
        }

        for(int i = n-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                currLength /= ch - '0';
                k %= currLength;
            } else {
                if(k == 0 || k == currLength) {
                    return "" + ch;
                }
                currLength--;
            }
        } 
        return "";
    }
}