class Solution {
    public int countArrangement(int n) {
        boolean vis[] = new boolean[n + 1];
        return ways(1, n, vis);
    }

    public int ways(int idx, int n, boolean vis[]) {
        if(idx > n) {
            return 1;
        }
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            if((idx % i == 0 || i % idx == 0) && !vis[i]) {
                vis[i] = true;
                cnt += ways(idx+1, n, vis);
                vis[i] = false;
            }
        }
        return cnt;
    }
}

// class Solution {
// public:
//     bool is_present(int ele, vector<int> &arr){
//         for(int i=0; i<arr.size(); i++){
//             if(arr[i]==ele) return true;
//         }

//         return false;
//     }
//     int find(int idx, int n, vector<int> arr){
//         if(idx>n){
//             return arr.size()==n;
//         }

//         int ways=0;

//         for(int i=1; i<=n; i++){
//             if((i%idx==0 || idx%i==0) && !is_present(i, arr)){
//                 arr.push_back(i);
//                 ways+=find(idx+1, n, arr);
//                 arr.pop_back();
//             }
//         }

//         return ways;
//     }
//     int countArrangement(int n) {
//         vector<int> arr;
//         int ans=find(1, n, arr);

//         return ans;
//     }
// };