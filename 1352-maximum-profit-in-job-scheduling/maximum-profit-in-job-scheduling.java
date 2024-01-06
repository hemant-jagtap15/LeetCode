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
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return ways(0, jobs, dp);
    }

    public int ways(int i, Tuple jobs[], int dp[]) {
        if(i == jobs.length) return 0;
        
        if(dp[i] != -1) return dp[i];

        int notTake = ways(i+1, jobs, dp);

        int take = jobs[i].pro;
        int nextIdx = lowerBound(jobs[i].end, jobs);
        
        if (nextIdx != -1) {
            take += ways(nextIdx, jobs, dp);
        }

        return dp[i] = Math.max(take, notTake);
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