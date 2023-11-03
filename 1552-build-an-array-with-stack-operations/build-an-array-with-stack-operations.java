class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int m = target.length;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            if(i == target[j]) {
                ans.add("Push");
                j++;
                if(j == m) break;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}