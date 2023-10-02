class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int minLeft[] = new int[n];
        minLeft[0] = nums[0];
        for(int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i-1], nums[i-1]);
        }
        Stack<Integer> s = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            if(nums[i] > minLeft[i]) {
                while(!s.isEmpty() && s.peek() <= minLeft[i]) {
                    s.pop();
                }
                if(!s.isEmpty() && s.peek() < nums[i]) return true;
                s.push(nums[i]);
            }
        }
        return false;
    }
}