class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> common = new HashSet<>();

        for (int val : nums1) {
            set1.add(val);
        }
        for (int val : nums2) {
            set2.add(val);
        }

        for(Integer key : set1) {
            if(set2.contains(key)) {
                common.add(key);
            }
        }

        // for(int key : common) {
        //     System.out.print(key + " ");
        //     System.out.println();
        // }

        int n = nums1.length;
        int n1 = set1.size();
        int n2 = set2.size();
        int c = common.size();

        return Math.min(n, Math.min(n1 - c, n / 2) + Math.min(n2 - c, n / 2) + c);
    }
}
