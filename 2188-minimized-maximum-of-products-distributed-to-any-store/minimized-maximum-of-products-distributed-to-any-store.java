class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int sum = 0;
        for(int val : quantities) {
            sum += val;
        }
        int high = (int)(1e5);

        while(low <= high) {
            int mid = (low + high) / 2;
            if(check(mid, n, quantities)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int maxAllow, int n, int quantities[]) {
        for(int i = 0; i < quantities.length; i++) {
            int products = quantities[i];
            n -= (products / maxAllow);
            if(products % maxAllow != 0) n--;

            if(n < 0) return false;
        }
        return true;
    }
}