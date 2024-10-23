class Solution {
    public int jump(int[] nums) {
       int farthest = 0;  // Track the farthest point we can reach
        int currentEnd = 0;  // The end of the current jump
        int jumps = 0;  // Number of jumps made

        if (nums.length <= 1) {
            return 0;  // No jumps needed if the array has 1 or fewer elements
        }

        // Iterate through the array but exclude the last element
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);  // Update the farthest point we can reach

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;  // Make a jump
                currentEnd = farthest;  // Update the end of the current jump

                // If the farthest point reaches or exceeds the last index, return the number of jumps
                if (farthest >= nums.length - 1) {
                    return jumps;
                }
            }
        }
        return 0;  
        
    }
    }
                     