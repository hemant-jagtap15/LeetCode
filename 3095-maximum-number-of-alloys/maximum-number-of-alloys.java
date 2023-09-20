class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long ans = 0;
        long low = 0;
        long high = (long)(1e9);

        while(low <= high) {
            long mid = (low + high) / 2;
            if(possible(mid, budget, composition, stock, cost)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)ans;
    }

    public boolean possible(long mid, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long minCost = Integer.MAX_VALUE;
        for(int i = 0; i < composition.size(); i++) {
            long currCost = 0;
            for(int j = 0; j < composition.get(i).size(); j++) {
                long curr = mid * composition.get(i).get(j);
                if(stock.get(j) >= curr) {
                    continue;
                } else {
                    long extra = (curr - stock.get(j)) * cost.get(j);
                    currCost += extra;
                }
            }
            minCost = Math.min(currCost, minCost);
        }
        return minCost <= budget;
    }
}