class Solution {
    class Tuple {
        int row;
        int sum;
        int val;
        Tuple(int row, int sum, int val) {
            this.row = row;
            this.sum = sum;
            this.val = val;
        }
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> {
            if(x.sum == y.sum) {
                return Integer.compare(y.row, x.row);
            }
            return Integer.compare(x.sum, y.sum);
        });

        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.get(i).size(); j++) {
                pq.add(new Tuple(i, i+j, nums.get(i).get(j)));
            }
        }

        int ans[] = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
            int curr = pq.peek().val;
            pq.remove();
            ans[i] = curr;
            i++;
        }
        return ans;
    }
}