class Solution {
    class Pair {
        int reward;
        int idx;
        Pair(int reward, int idx) {
            this.reward = reward;
            this.idx = idx;
        }
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.reward, x.reward));

        for(int i = 0; i < reward1.length; i++) {
            pq.add(new Pair(reward1[i] - reward2[i], i));
        }
        int maxSum = 0;
        for(int val : reward2) {
            maxSum += val;
        }

        for(int i = 0; i < k; i++) {
            Pair it = pq.peek();
            pq.remove();
            int index = it.idx;
            
            maxSum -= reward2[index];
            maxSum += reward1[index];
            
            //System.out.println(maxSum);
        }
        return maxSum;
    }
}