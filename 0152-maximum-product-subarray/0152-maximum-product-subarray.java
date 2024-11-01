class Solution {
    public int maxProduct(int[] nums) {
        int n =nums.length;
        int leftMultiple  = 1;
        int rightMultiple = 1;
        int ans = nums[0];
        for(int i=0;i<n;i++){
            leftMultiple = leftMultiple == 0?1:leftMultiple;
            rightMultiple = rightMultiple == 0?1:rightMultiple;
            
            leftMultiple *= nums[i];
            rightMultiple *= nums[n-1-i];
            ans =Math.max(ans, Math.max(leftMultiple, rightMultiple));
        }
        return ans;
    }
}