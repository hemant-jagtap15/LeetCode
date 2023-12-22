class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ans = 0;
        int rightOne = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') rightOne++;
        }
        int leftZero = 0;

        for(int i = 0; i < n-1; i++) {
            if(s.charAt(i) == '1') {
                rightOne--;
            } else {
                leftZero++;
            }
            ans = Math.max(ans, rightOne + leftZero);
        }
        return ans;
    }
}