class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        
        int prefix[] = new  int[n+1];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        for(int i = 0; i < n; i++) {
            int backLeft = i - 0;
            int frontLeft = n - i - 1;
            int value = 0;
            if(i != 0) {
                value += (backLeft*nums[i]) - prefix[i-1];
            }
            value += (prefix[n-1] - prefix[i]) - (frontLeft * nums[i]);
            result[i] = value;
    
        }

        return result;
    }
}