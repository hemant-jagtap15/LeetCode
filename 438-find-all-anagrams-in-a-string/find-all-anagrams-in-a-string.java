class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        
        char tempP[] = p.toCharArray();
        Arrays.sort(tempP);
        p = new String(tempP);
        for(int i = 0; i <= n-m; i++) {
            String str = s.substring(i, i+m);
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            str = new String(temp);
            if(str.equals(p)) ans.add(i);
        }
        return ans;
    }
}