class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if(nums.length < k){
            return 0;
        }
        long maxSum=0;
        long currentSum=0;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        for(int right=0;right<nums.length;right++){
            currentSum+=nums[right];
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                currentSum-=nums[left];
                left++;
            }
            set.add(nums[right]);
            if(right-left+1 == k){
                maxSum = Math.max(maxSum,currentSum);
                currentSum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        return maxSum;
        
    }
}