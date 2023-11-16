class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String str : nums) {
            set.add(str);
        }
        int n = nums.length;
        return ways(n, "", set);
    }

    public String ways(int n, String str, HashSet<String> set) {
        if(str.length() == n) {
            if(!set.contains(str)) {
                return str;
            }
            return "";
        }
        
        
        String putZero = ways(n, str + "0", set);
        if(putZero.length() > 0) {
            return putZero;
        }
        return ways(n, str + "1", set);
    }
}