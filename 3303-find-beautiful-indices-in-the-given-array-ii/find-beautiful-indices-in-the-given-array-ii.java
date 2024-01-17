class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> forA = KMP(a, s);
        List<Integer> forB = KMP(b, s);;
        
        List<Integer> ans = new ArrayList<>();
        
        int j = 0;
        for(int i = 0; i < forA.size(); i++) {
            while(j < forB.size() && forA.get(i) > forB.get(j) && Math.abs(forA.get(i) - forB.get(j)) > k) j++;
            if(j < forB.size() && Math.abs(forA.get(i) - forB.get(j)) <= k) ans.add(forA.get(i));
        }
        
        return ans;
    }

    public List<Integer> KMP(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        List<Integer> result = new ArrayList<>();

        int lps[] = new int[m];
        computeLPS(pat, lps);

        int i = 0;//idx for text
        int j = 0;//idx for pattern

        while(i < n) {
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if(j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if(i < n && pat.charAt(j) != txt.charAt(i)) {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    public void computeLPS(String pattern, int lps[]) {
        int m = pattern.length();
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while(i < m) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}