class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        long cnt1 = 0;
        long cnt2 = 0;
        for(int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            if(nums1[i] == 0) cnt1++;
        }

        for(int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
            if(nums2[i] == 0) cnt2++;
        }

        if(cnt1 == 0 && cnt2 == 0) {
            if(sum1 == sum2) return sum1;
            return -1;
        }

        else if(cnt1 == 0) {
            if(sum2+cnt2 > sum1) return -1;
            return sum1;
        }

        else if(cnt2 == 0) {
            if(sum1+cnt1 > sum2) return -1;
            return sum2;
        }

        else {
            if(sum1+cnt1 > sum2+cnt2) {
                return sum1+cnt1;
            }
        }
        return sum2+cnt2;
    }
}