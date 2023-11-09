class Solution {
    class Pair {
        String s;
        int freq;
        Pair(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<Pair> temp = new ArrayList<>();
        for(String key : map.keySet()) {
            temp.add(new Pair(key, map.get(key)));
        }
        Collections.sort(temp, (x, y) -> {
            if(x.freq == y.freq) {
                return x.s.compareTo(y.s);
            }
            return Integer.compare(y.freq, x.freq);
        });
        //System.out.print(temp.get(0).s);

        for(int i = 0; i < k; i++) {
            ans.add(temp.get(i).s);
        }
        return ans;
    }
}