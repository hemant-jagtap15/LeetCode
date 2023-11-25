class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        
        int leftSum = 0;
        int rightSum = 0;
        for(int val : nums) {
            rightSum += val;
        }

        for(int i = 0; i < n; i++) {
            int backLeft = i - 0;
            int frontLeft = n - i - 1;
            int value = 0;
            rightSum -= nums[i];
            if(i != 0) {
                value += (backLeft*nums[i]) - leftSum;
            }
            value += (rightSum) - (frontLeft * nums[i]);
            leftSum += nums[i];
            result[i] = value;
    
        }

        return result;
    }
}