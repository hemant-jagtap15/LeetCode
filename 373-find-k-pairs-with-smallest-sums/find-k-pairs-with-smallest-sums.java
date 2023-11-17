import java.util.*;

class Solution {
    class Sums {
        int x;
        int y;
        int sum;

        Sums(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Sums> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.sum, y.sum));
        pq.add(new Sums(0, 0, nums1[0] + nums2[0]));

        HashSet<ArrayList<Integer>> set = new HashSet<>(); // visited
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(0);
        set.add(temp);

        while (!pq.isEmpty() && k > 0) {
            Sums it = pq.poll();
            int i = it.x;
            int j = it.y;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[j]);
            ans.add(list);

            if (j + 1 < nums2.length) {
                ArrayList<Integer> next = new ArrayList<>();
                next.add(i);
                next.add(j + 1);
                if (!set.contains(next)) {
                    pq.add(new Sums(i, j + 1, nums1[i] + nums2[j + 1]));
                    set.add(next);
                }
            }
            if (i + 1 < nums1.length) {
                ArrayList<Integer> next = new ArrayList<>();
                next.add(i + 1);
                next.add(j);
                if (!set.contains(next)) {
                    pq.add(new Sums(i + 1, j, nums1[i + 1] + nums2[j]));
                    set.add(next);
                }
            }
            k--;
        }

        return ans;
    }
}
