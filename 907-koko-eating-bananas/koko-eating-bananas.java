class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = 0;
        for(int val : piles) {
            maxi = Math.max(maxi, val);
        }
        int low = 1;
        int high = maxi;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(check(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int check(int piles[], int rate) {
        int count = 0;
        for(int i = 0; i < piles.length; i++) {
            count += Math.ceil(piles[i]/(double)rate);
        }
        return count;
    }
}