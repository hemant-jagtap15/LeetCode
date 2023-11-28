class Solution {
    public int numberOfWays(String corridor) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = corridor.length();
        for(int i = 0; i < n; i++) {
            char ch = corridor.charAt(i);
            if(ch == 'S') {
                list.add(i);
            }
        }

        // for(int val : list) {
        //     System.out.print(val + " ");
        // }

        if(list.size() == 0 || list.size() % 2 != 0) return 0;
        int mod = (int)(1e9 + 7);
        long ans = 1;
        int prev = list.get(1);
        for(int i = 2; i < list.size(); i += 2) {
            int currLen = list.get(i) - prev;
            ans = (ans * currLen) % mod;
            prev = list.get(i + 1);
        }
        return (int)ans;
    }
}