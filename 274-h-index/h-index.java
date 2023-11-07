class Solution {
    public int hIndex(int[] citations) {
        int max = citations[0];
        int n = citations.length;
        for(int i = 1; i < n; i++) {
            max = Math.max(max, citations[i]);
        }
        int low = 0;
        int high = max;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(isPossible(mid, citations)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public boolean isPossible(int h, int citations[]) {
        int n = citations.length;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(citations[i] >= h) {
                cnt++;
            }
        }
        if(cnt >= h) return true;
        return false;
    }
}