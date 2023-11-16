class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < nums.length; i++) {
            char ch = nums[i].charAt(i);
            char curr = ch == '0' ? '1' : '0';
            sb.append(curr);
        }
        return sb.toString();
    }
}