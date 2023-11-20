class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int P = 0;
        int G = 0;
        int M = 0;
        int n = garbage.length;
        int pickTime = 0;
        for(int i = 0; i < n; i++) {
            String curr = garbage[i];
            pickTime += curr.length();
            for(int j = 0; j < curr.length(); j++) {
                if(curr.charAt(j) == 'P') {
                    P = i;
                } else if(curr.charAt(j) == 'G') {
                    G = i;
                } else {
                    M = i;
                }
            }
        }
        
        int prefixTime[] = new int[travel.length];
        prefixTime[0] = travel[0];
        for(int i = 1; i < travel.length; i++) {
            prefixTime[i] = prefixTime[i-1] + travel[i];
        }

        int travelTime = 0;
        if(G != 0) {
            travelTime += prefixTime[G-1];
        }
        if(P != 0) {
            travelTime += prefixTime[P-1];
        }
        if(M != 0) {
            travelTime += prefixTime[M-1];
        }

        return pickTime + travelTime;
    }
}