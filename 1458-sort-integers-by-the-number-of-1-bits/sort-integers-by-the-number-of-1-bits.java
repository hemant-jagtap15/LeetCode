class Solution {
    class Pair implements Comparable<Pair>{
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair p2) {
            if(this.second == p2.second) {
                return this.first - p2.first;
            } else {
                return this.second - p2.second;
            }
        }
    }

    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Pair temp[] = new Pair[n];
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int num = arr[i];
            while(num != 0) {
                if((num & 1) != 0) cnt++;
                num = num >> 1;
            }
            temp[i] = new Pair(arr[i], cnt);
        }
        Arrays.sort(temp);
        
        for(int i = 0; i < n; i++) {
            arr[i] = temp[i].first;
        }
        return arr;
    }
}