class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char ch1[] = s1.toCharArray();
        Arrays.sort(ch1);
        s1 = new String(ch1);

        int k = s1.length();
        int i = 0;
        while(i <= s2.length()-k) {
            String subStr = s2.substring(i, i + k);
            char ch[] = subStr.toCharArray();
            Arrays.sort(ch);
            subStr = new String(ch);
            if(subStr.equals(s1)) return true;
            i++;
        }
        return false;
    }
}