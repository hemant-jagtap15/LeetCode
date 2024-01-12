class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        if(n % 2 == 1) return false;
        
        String a = "";
        String b = "";
        for(int i = 0; i < n; i++) {
            if(i < n / 2) {
                a += s.charAt(i);
            } else {
                b += s.charAt(i);
            }
        }
        int cnt1 = countVowels(a);
        int cnt2 = countVowels(b);
        
        if(cnt1 == cnt2) return true;
        return false;
    }
    
    public int countVowels(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                cnt++;
            }
        }
        return cnt;
    }
}