class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> arr : paths) {
            map.put(arr.get(0), arr.get(1));
        }

        for(String key : map.keySet()) {
            String dest = map.get(key);
            if(!map.containsKey(dest)) {
                return dest;
            }
        }
        return "";
    }
}