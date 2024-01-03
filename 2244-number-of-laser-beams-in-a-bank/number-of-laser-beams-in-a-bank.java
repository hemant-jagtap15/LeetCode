class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prev = 0;
        for(String str : bank) {
            int cnt = 0;
            for(char ch : str.toCharArray()) {
                if(ch == '1') cnt++;
            }
            if(cnt != 0) {
                ans += prev * cnt;
                prev = cnt;
            }
        }

        return ans;
    }
}