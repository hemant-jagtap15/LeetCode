class Solution {
    public String largestGoodInteger(String num) {
        int max = (int)(-1e9);
        int n = num.length();
        for(int i = 0; i < n-2; i++) {
            String str = num.substring(i, i+3);
            if(check(str)) {
                int temp = Integer.parseInt(str);
                max = Math.max(temp, max);
            }
        }
        if(max == (int)(-1e9)) return "";
        if(max == 0) return "000";
        return Integer.toString(max);
    }

    public boolean check(String str) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()) {
            set.add(ch);
        }
        return set.size() == 1 ? true : false;
    }
}