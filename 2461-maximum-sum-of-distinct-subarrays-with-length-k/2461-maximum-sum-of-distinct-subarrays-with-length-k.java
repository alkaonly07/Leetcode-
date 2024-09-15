class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        
        long maxSum = 0;
        long currentSum = 0;
        Set<Integer> set = new HashSet<>();
        
        // Step 2: Sliding window approach
        int left = 0; // Left pointer for the window
        for (int right = 0; right < nums.length; right++) {
            // Add the current element to the window
            currentSum += nums[right];
            
            // If we encounter a duplicate, move the left pointer to make elements distinct
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            
            // Add the current element to the set after ensuring it's distinct
            set.add(nums[right]);
            
            // If the window size is exactly k, check if it's the maximum sum
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                
                // Before moving the window, remove the leftmost element from the window
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        
        return maxSum;
        
    }
}