class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int freq[] = new int[n+1];

        for(int val : nums) {
            if(freq[val] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(freq[val]).add(val);
            freq[val]++;
        }

        return ans;
    }
}