class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums) {
            set.add(val);
        }
        int arr[] = new int[set.size()];
        int idx = 0;
        for(Integer key : set) {
            arr[idx++] = key; 
        }
        Arrays.sort(arr);
        int ans = n;
        
        for(int i = 0; i < arr.length; i++) {
            int left = arr[i];
            int right = arr[i] + n - 1;
            
            int alreadyExist = check(arr, right);
            int count = alreadyExist - i;
            ans = Math.min(ans, n - count);
        }
        return ans;
    }

    public int check(int arr[], int ele) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] <= ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}