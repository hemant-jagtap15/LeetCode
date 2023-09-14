class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prifix[] = new int[n+2];
        prifix[0] = 0;
        prifix[n+1] = 0;
        int m = n+2;
        for(int i = 1; i <= n; i++) {
            prifix[i] = prifix[i-1] + nums[i-1];
        }
        // for(int i = 0; i < m; i++) {
        //     System.out.print(prifix[i] + " ");
        // }

        for(int i = 1; i < m-1; i++) {
            int left = prifix[i-1];
            int right = prifix[m-2] - prifix[i];
            if(left == right) return i-1;
        }
        return -1;
    }
}