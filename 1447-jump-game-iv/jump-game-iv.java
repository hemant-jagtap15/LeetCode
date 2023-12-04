class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        boolean vis[] = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                int curr = q.peek();
                q.remove();
                if (curr == n - 1) return steps;

                int left = curr - 1;
                int right = curr + 1;

                if (left >= 0 && !vis[left]) {
                    q.add(left);
                    vis[left] = true;
                }
                if (right < n && !vis[right]) {
                    q.add(right);
                    vis[right] = true;
                }

                if (map.containsKey(arr[curr])) {
                    ArrayList<Integer> index = map.get(arr[curr]);
                    for (int val : index) {
                        if (!vis[val]) {
                            q.add(val);
                            vis[val] = true;
                        }
                    }
                    map.remove(arr[curr]);
                }
                size--;
            }
            steps++;
        }
        return steps;
    }
}
