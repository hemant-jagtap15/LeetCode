class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0] != 1) {
            arr[0] = 1;
        }
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[i-1]) > 1) {
                arr[i] = arr[i-1] + 1;
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }
}