class Solution {
    public int minimumOperations(String num) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = num.length();
        char arr[] = num.toCharArray();
        
        for (int i = n - 1; i >= 0; i--) {
            if ((arr[i] == '0' || arr[i] == '5') && map.getOrDefault('0', 0) > 0) {
                int s = n - i;
                return s - 2;
            } 
            if ((arr[i] == '2' || arr[i] == '7') && map.getOrDefault('5', 0) > 0) {
                int s = n - i;
                return s - 2;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == '0') cnt++;
        }
        
        return n - cnt;
    }
}
