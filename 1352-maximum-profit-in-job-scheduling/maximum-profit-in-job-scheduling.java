class Solution {
    class Tuple {
        int start;
        int end;
        int pro;
        Tuple(int start, int end, int pro) {
            this.start = start;
            this.end = end;
            this.pro = pro;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Tuple jobs[] = new Tuple[n];
        for(int i = 0; i < n; i++) {
            jobs[i] = new Tuple(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (x, y) -> Integer.compare(x.start, y.start));
        // for(int i = 0; i < n; i++) {
        //     System.out.println(jobs[i].start + " " + jobs[i].end + " " + jobs[i].pro);
        // }
        int dp[] = new int[n+1];
        int max = 0;
        
        for(int i = n-1; i >= 0; i--) {
            int notTake = dp[i+1];

            int take = jobs[i].pro;
            int nextIdx = lowerBound(jobs[i].end, jobs);
            
            if (nextIdx != -1) {
                take += dp[nextIdx];
            }

            dp[i] = Math.max(take, notTake);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public int lowerBound(int k, Tuple jobs[]) {
        int low = 0;
        int high = jobs.length - 1;
        int idx = -1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(jobs[mid].start >= k) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}