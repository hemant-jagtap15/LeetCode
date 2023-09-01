class Solution {
    public int maximumScore(int a, int b, int c) {
        int arr[] = {a, b, c};
        Arrays.sort(arr);
        
        int sum1 = arr[0] + arr[1];
        int sum2 = arr[2];
        int res = 0;
        
        if(sum1 >= sum2) {
            res = sum2 + (sum1 - sum2) / 2;
        } else {
            res = sum1;
        }
        
        return res;
    }
}