class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = check(s);
        String t1 = check(t);
        return s1.equals(t1);
    }

    public String check(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '#' && sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else if(str.charAt(i) != '#'){
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}