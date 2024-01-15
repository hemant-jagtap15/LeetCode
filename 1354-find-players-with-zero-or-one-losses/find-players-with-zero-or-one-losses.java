class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> winners = new HashMap<>();
        HashMap<Integer, Integer> lossers = new HashMap<>();

        for(int arr[] : matches) {
            winners.put(arr[0], winners.getOrDefault(arr[0], 0) + 1);
            lossers.put(arr[1], lossers.getOrDefault(arr[1], 0) + 1);
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();

        for(Integer key : winners.keySet()) {
            if(!lossers.containsKey(key)) {
                notLost.add(key);
            }
        }
        for(Integer key : lossers.keySet()) {
            if(lossers.get(key) == 1) {
                oneLost.add(key);
            }
        }
        Collections.sort(notLost);
        Collections.sort(oneLost);
        ans.add(notLost);
        ans.add(oneLost);

        return ans;
    }
}