class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int startIdx = l[i];
            int endIdx = r[i];
            if(check(nums, startIdx, endIdx)){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public boolean check(int nums[], int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        int cd = list.get(1) - list.get(0);
        for(int i = 2; i < list.size(); i++) {
            if((list.get(i) - list.get(i-1)) != cd) return false;
        }
        return true;
    }
}