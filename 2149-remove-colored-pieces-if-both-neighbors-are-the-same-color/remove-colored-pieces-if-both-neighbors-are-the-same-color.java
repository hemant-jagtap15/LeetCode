class Solution {
    public boolean winnerOfGame(String colors) {
        int cntA = 0;
        int cntB = 0;
        int n = colors.length();
        for(int i = 1; i < n-1; i++) {
            if(colors.charAt(i) == 'A') {
                if(colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A') cntA++;
            }
            else if(colors.charAt(i) == 'B') {
                if(colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B') cntB++;
            }
        }

        if(cntA > cntB) return true;
        return false;
    }
}