class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int start = 0;
        int end = n-1;
        boolean flag = true;
        int Alice = 0;
        int Bob = 0;
        while(start <= end) {
            if(flag) {
                if(piles[start] >= piles[end]) {
                    Alice += piles[start];
                    start++;
                } else {
                    Alice += piles[end];
                    end--;
                }
                flag = false;
            } else {
                if(piles[start] <= piles[end]) {
                    Bob += piles[start];
                    start++;
                } else {
                    Bob += piles[end];
                    end--;
                }
                flag = true;
            }
        }

        if(Alice > Bob) return true;
        return false;
    }
}