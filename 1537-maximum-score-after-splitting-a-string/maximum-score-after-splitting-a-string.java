class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n-1; i++) {
            int left = leftZero(i, s);
            int right = rightOne(i+1, s);
            ans = Math.max(left + right, ans);
        }
        return ans;
    }

    public int leftZero(int i, String s) {
        int zeroCnt = 0;
        for(int j = 0; j <= i; j++) {
            if(s.charAt(j) == '0') zeroCnt++;
        }
        return zeroCnt;
    }

    public int rightOne(int i, String s) {
        int oneCnt = 0;
        for(int j = i; j < s.length(); j++) {
            if(s.charAt(j) == '1') oneCnt++;
        }
        return oneCnt;
    }

}