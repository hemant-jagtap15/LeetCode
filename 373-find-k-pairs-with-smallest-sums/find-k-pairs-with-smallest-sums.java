class Solution {
    // class Sums implements Comparable<Sums> {
    //     ArrayList<Integer> arr;
    //     int sum;

    //     Sums(ArrayList<Integer> arr, int sum) {
    //         this.arr = arr;
    //         this.sum = sum;
    //     }

    //     public int compareTo(Sums s2) {
    //         return this.sum - s2.sum;
    //     }
    // }

    class Sums {
        ArrayList<Integer> arr;
        int sum;

        Sums(ArrayList<Integer> arr, int sum) {
            this.arr = arr;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Sums> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.sum, x.sum));

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                ArrayList<Integer> arr = new ArrayList<>();
                int sum = nums1[i] + nums2[j];
                if(pq.size() < k) {
                    arr.add(nums1[i]);
                    arr.add(nums2[j]);
                    pq.add(new Sums(arr, sum));
                } else if(pq.peek().sum > sum) {
                    pq.remove();
                    arr.add(nums1[i]);
                    arr.add(nums2[j]);
                    pq.add(new Sums(arr, sum));
                } else {
                    break;
                }
            }
        }

        for(int i = 0; i < k; i++) {
            if(!pq.isEmpty()) {
                ans.add(pq.peek().arr);
                pq.remove();
            } else {
                break;
            }
            
        }

        return ans;
    }
}