class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<2){
            return nums[0];
        }
        int[] leavingLast = new int[n-1];
        int[] leavingFirst = new int[n-1];
        
        for(int i = 0;i< n-1;i++){
            leavingLast[i] = nums[i];
            leavingFirst[i] = nums[i+1];
        }
        
        int maxAmountAfterLeavingFirst = robHelper(leavingFirst);
        int maxAmountAfterLeavingLast = robHelper(leavingLast);
        
        return Math.max(maxAmountAfterLeavingFirst,maxAmountAfterLeavingLast );
        
    }
    private int robHelper(int[] arr){
        if(arr.length <2){
            return arr[0];
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2;i<arr.length;i++){
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }
        return dp[arr.length-1];
    }
}