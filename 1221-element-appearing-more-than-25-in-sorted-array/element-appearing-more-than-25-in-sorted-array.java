class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int need = ((n * 25) / 100) + 1;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) >= need) return key;
        }
        return -1;
    }
}