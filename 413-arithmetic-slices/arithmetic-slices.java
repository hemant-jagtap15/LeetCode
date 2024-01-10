class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = i; j < n; j++) {
                list.add(nums[j]);
                if(check(list)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean check(ArrayList<Integer> list) {
        if(list.size() < 3) return false;
        int d = list.get(1) - list.get(0);
        for(int i = 2; i < list.size(); i++) {
            if(list.get(i) - list.get(i-1) != d) return false;
        }
        return true;
    }
}