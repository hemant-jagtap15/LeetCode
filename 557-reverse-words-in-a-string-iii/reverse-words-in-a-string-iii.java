class Solution {
    public String reverseWords(String s) {
        String temp[] = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        String ans = "";
        int n = temp.length;
        for(int i = 0; i < n; i++) {
            sb.append(temp[i]);
            sb.reverse();
            if(i != n-1) {
                ans += sb.toString() + " ";
            } else {
                ans += sb.toString();
            }
            sb.delete(0, sb.length());
        }
        return ans;
    }
}