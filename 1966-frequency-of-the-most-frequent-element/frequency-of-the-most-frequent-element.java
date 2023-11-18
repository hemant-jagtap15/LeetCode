class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;

        long prefixSum[] = new long[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int i = 0;
        while(i < n) {
            int targetIdx = i;
            int equals = maxPossible(nums, prefixSum, k, targetIdx);
            max = Math.max(max, equals);
            i++;
        }
        return max;
    }

    public int maxPossible(int nums[], long prefixSum[], int k, int targetIdx) {
        int low = 0;
        int high = targetIdx - 1;
        int target = nums[targetIdx];
        int best = targetIdx;

        while(low <= high) {
            int mid = (low + high) / 2;
            long noBtw = targetIdx - mid + 1;
            long totSum = target * noBtw;
            long originalSum = prefixSum[targetIdx] - prefixSum[mid] + nums[mid];
            long operations = totSum - originalSum;

            if(operations > k) {
                low = mid + 1;
            } else {
                best = mid;
                high = mid - 1;
            }
        }
        return targetIdx - best + 1;
    }
}