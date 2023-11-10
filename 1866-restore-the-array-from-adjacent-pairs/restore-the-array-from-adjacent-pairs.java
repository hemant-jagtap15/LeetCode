class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();//graph
        int ans[] = new int[n+1];
        for(int row[] : adjacentPairs) {
            if(!map.containsKey(row[0])) map.put(row[0], new ArrayList<>());
            if(!map.containsKey(row[1])) map.put(row[1], new ArrayList<>());
            map.get(row[0]).add(row[1]);
            map.get(row[1]).add(row[0]);
        }
        int start = 0;
        for(Integer key : map.keySet()) {
            if(map.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        dfs(start, map, list, set);
        
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public void dfs(int start, HashMap<Integer, ArrayList<Integer>> map, ArrayList<Integer> list, HashSet<Integer> set) {
        set.add(start);
        list.add(start);
        ArrayList<Integer> children = map.get(start);

        for(int child : children) {
            if(!set.contains(child)) {
                dfs(child, map, list, set);
            }
        }
    }
}