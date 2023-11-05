class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < n; i++) {
            q.add(arr[i]);
            max = Math.max(max, arr[i]);
        }

        int curr = arr[0];
        int cnt = 0;

        while(true) {
            if(curr > q.peek()) {
                cnt++;
                int sm = q.remove();
                q.add(sm);
            } else {
                q.add(curr);
                curr = q.peek();
                q.remove();
                cnt = 1;
            }
            if(cnt == k || curr == max) {
                return curr;
            }
        }
    }
}