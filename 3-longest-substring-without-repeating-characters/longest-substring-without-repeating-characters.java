class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int count = 0;
        while(right < n) {
            char ch = s.charAt(right);
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}