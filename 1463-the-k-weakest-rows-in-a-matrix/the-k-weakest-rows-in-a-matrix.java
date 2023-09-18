class Solution {
    class Pair {
        int soldiers;
        int idx;
        Pair(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
    
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> {
            int cmd = Integer.compare(x.soldiers, y.soldiers);
            if(cmd == 0) {
                cmd = Integer.compare(x.idx, y.idx);
            }
            return cmd;
        });

        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int sld : mat[i]) {
                if(sld == 0) break;
                cnt++;
            }
            pq.add(new Pair(cnt, i));
        }

        int ans[] = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.peek().idx;
            pq.remove();
        }
        return ans;
    }
}
