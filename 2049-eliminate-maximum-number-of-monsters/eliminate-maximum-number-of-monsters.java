class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = dist.length;
        for(int i = 0; i < n; i++) {
            pq.add((int)Math.ceil(dist[i]/(double)speed[i]));
        }
        int time = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int tm = pq.peek();
            pq.remove();
            if(time < tm) {
                cnt++;
                time++;
            } else {
                break;
            }
        }
        return cnt;
    }
}