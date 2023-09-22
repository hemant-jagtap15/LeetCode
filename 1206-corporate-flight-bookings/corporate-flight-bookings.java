class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];

        for(int row[] : bookings) {
            int from = row[0];
            int to = row[1];
            int seats = row[2];
            for(int i = from; i <= to; i++) {
                ans[i-1] += seats;
            }
        }
        return ans;
    }
}