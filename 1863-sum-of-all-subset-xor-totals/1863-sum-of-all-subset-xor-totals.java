class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int totalSubsets = 1 << n;
        for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
            int currentXOR = 0;
            for (int i = 0; i < n; i++) {
                if ((subsetMask & (1 << i)) != 0) {
                    currentXOR ^= nums[i];
                }
            }
            sum += currentXOR;
        }
        return sum;
    }
}
