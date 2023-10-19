class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean vis[] = new boolean[n];
        ways(nums, ans, list, vis);
        return ans;
    }

    public void ways(int nums[], List<List<Integer>> ans, List<Integer> list, boolean vis[]) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(vis[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !vis[i-1]) continue;
            vis[i] = true;
            list.add(nums[i]);
            ways(nums, ans, list, vis);
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }
}