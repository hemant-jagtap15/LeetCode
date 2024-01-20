class Solution {
    int mod = (int)(1e9+7);
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int leftSmaller[] = new int[n];
        left(arr, leftSmaller);

        int rightSmaller[] = new int[n];
        right(arr, rightSmaller);

        long ans = 0;
        for(int i = 0; i < n; i++) {
            long leftCount = i - leftSmaller[i];
            long rightCount = rightSmaller[i] - i;
            ans = (ans + (leftCount * rightCount * arr[i])) % mod; 
        }
        return (int)ans % mod;
    }

    public void left(int arr[], int leftSmaller[]) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            while(!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) leftSmaller[i] = -1;
            else {
                leftSmaller[i] = s.peek();
            }
            s.push(i);
        }
    }

    public void right(int arr[], int rightSmaller[]) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;

        for(int i = n-1; i >= 0; i--) {
            while(!s.empty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) rightSmaller[i] = n;
            else {
                rightSmaller[i] = s.peek();
            }
            s.push(i);
        }
    }
}
