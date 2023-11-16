class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int ch[] = new int[26];
            for(int j = i; j < n; j++) {
                int curr = s.charAt(j) - 'a';
                ch[curr]++;
                ans += (getMax(ch) - getMin(ch));
            }
        }
        return ans;
    }

    public int getMax(int ch[]) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < ch.length; i++) {
            max = Math.max(max, ch[i]);
        }
        return max;
    }

    public int getMin(int ch[]) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] != 0) {
                min = Math.min(min, ch[i]);
            }
        }
        return min;
    }
}
