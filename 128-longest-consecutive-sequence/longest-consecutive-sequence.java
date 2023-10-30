class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int val : nums) {
            set.add(val);
        }
        int cnt = 0;
        int prev = -1;
        int max = 0;
        for(int val : set) {
            int curr = val;
            System.out.print(val + " ");
            if(cnt == 0) {
                cnt++;
                prev = curr;
            } else if(prev + 1 != curr) {
                max = Math.max(max, cnt);
                cnt = 1;
                prev = curr;
            } else {
                cnt++;
                prev = curr;
            }
        }
        max = Math.max(cnt, max);
        return max;
    }
}