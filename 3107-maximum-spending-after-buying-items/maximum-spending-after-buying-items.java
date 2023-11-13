class Solution {
    public long maxSpending(int[][] values) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int val[] : values) {
            for(int i = 0; i < val.length; i++) {
                list.add(val[i]);
            }
        }
        Collections.sort(list);
        long day = 1;
        long ans = 0;
        for(int i = 0; i < list.size(); i++) {
            ans += list.get(i) * day;
            day++;
        }
        return ans;
    }
}