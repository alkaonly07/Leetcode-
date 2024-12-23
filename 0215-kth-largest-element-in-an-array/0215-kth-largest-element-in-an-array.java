class Solution {
    public int findKthLargest(int[] nums, int k) {
         int n = nums.length;
        // Convert kth largest to index in sorted array
        int targetIndex = n - k;
        return quickSelect(nums, 0, n - 1, targetIndex);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        // Choose a random pivot to improve performance
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int partitionIndex = partition(nums, left, right, pivotIndex);

        // If partition index matches the target index, return the value
        if (partitionIndex == targetIndex) {
            return nums[partitionIndex];
        } else if (partitionIndex < targetIndex) {
            // Search in the right part
            return quickSelect(nums, partitionIndex + 1, right, targetIndex);
        } else {
            // Search in the left part
            return quickSelect(nums, left, partitionIndex - 1, targetIndex);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        // Move pivot to the end
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // Move all smaller elements to the left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}