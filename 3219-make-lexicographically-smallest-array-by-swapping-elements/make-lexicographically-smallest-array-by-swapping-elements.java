class Solution {
    class Pair {
        int ele;
        int idx;

        Pair(int ele, int idx) {
            this.ele = ele;
            this.idx = idx;
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int idx, boolean vis[], ArrayList<Integer> temp, ArrayList<Integer> index, int nums[]) {
        vis[idx] = true;
        index.add(idx);
        temp.add(nums[idx]);
        for(int child : adj.get(idx)) {
            if(!vis[child]) {
                dfs(adj, child, vis, temp, index, nums);
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int ans[] = new int[n];
        
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Pair(nums[i], i));
        }
        Collections.sort(list, (x, y) -> Integer.compare(x.ele, y.ele));

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            int val1 = list.get(i).ele;
            int u = list.get(i).idx;
            int val2 = list.get(i+1).ele;
            int v = list.get(i+1).idx;
            if((val2 - val1) <= limit) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }

        boolean vis[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                ArrayList<Integer> index = new ArrayList<>();
                dfs(adj, i, vis, temp, index, nums);
                Collections.sort(temp);
                Collections.sort(index);

                for(int j = 0; j < temp.size(); j++) {
                    ans[index.get(j)] = temp.get(j);
                }
            }
        }
        return ans;
    }
}