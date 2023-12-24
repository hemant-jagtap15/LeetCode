class Solution {
    public int minOperations(String s) {
        char arr[] = s.toCharArray();
        int cnt = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = arr[i];
            if(i % 2 != ch - '0') cnt++;
        }
        return Math.min(cnt, s.length() - cnt);
    }
}