class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int n = cost.length;
        // int[] mincost= new int[n+1];
        // mincost[0] = 0;
        // mincost[1] = 0;
        // for(int i=2;i<=n;i++){
        //     mincost[i] = Math.min((cost[i-1]+mincost[i-1]), (cost[i-2]+mincost[i-2]));
        // }
        // return mincost[n];
        
        int prev2 = cost[0];
        int prev1 = cost[1];
        
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}