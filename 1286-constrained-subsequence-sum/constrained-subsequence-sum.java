class Solution {
    class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int dp[] = new int[n];
        for(int i = 0; i < n ; i++) {
            dp[i] = nums[i];
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.first, x.first));
        pq.add(new Pair(dp[0], 0));
        int ans = nums[0];
        for(int i = 1; i < n; i++) {
            while(!pq.isEmpty() && (i - pq.peek().second) > k) {
                pq.remove();
            }
            dp[i] = Math.max(dp[i], nums[i] + pq.peek().first);
            pq.add(new Pair(dp[i], i));
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}  