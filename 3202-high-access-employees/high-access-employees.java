class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n = access_times.size();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(List<String> arr : access_times) {
            String employee = arr.get(0);
            int time = Integer.parseInt(arr.get(1));
            if(!map.containsKey(employee)) {
                map.put(employee, new ArrayList<>());
            }
            map.get(employee).add(time);
        }
        List<String> ans = new ArrayList<>();
        for(String key : map.keySet()) {
            ArrayList<Integer> times = map.get(key);
            if(times.size() < 3) continue;
            Collections.sort(times);
            int len = times.size();
            for(int i = 0; i  < len-2; i++) {
                if(times.get(i+2) < times.get(i) + 100) {
                    ans.add(key);
                    break;
                }
            } 
        }
        return ans;
    }
}