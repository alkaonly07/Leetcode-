class Solution {
    public int findKthLargest(int[] nums, int k) {
//         return quickSelect(nums, 0, nums.length-1, nums.length-k);
//     }
//     private int quickSelect(int[] nums, int left, int right, int k){
//         if(left == right){
//             return nums[left];
//         }
//         int pivotIndex = partition( nums, left,right);
//         if(pivotIndex == k){
//             return nums[pivotIndex];
//         }
//         else if(k >pivotIndex ){
//            return quickSelect(nums, pivotIndex+1,right,k);
//         }
//         else{
//            return quickSelect(nums,left, pivotIndex -1,k);
//         }
        
//     }
//     private int partition(int[] nums, int left, int right){
//         int i = left;
//         int pivot = nums[right];
//         for(int j=left;j<right;j++){
//             if(nums[j] < pivot){
//                 swap(nums, i, j);
//                 i++;
//             }
//         }
//         swap(nums, i, right);
//         return i;
        
//     }
//     private void swap(int[] nums, int i, int j){
//         int temp = nums[i];
//         nums[i]= nums[j];
//         nums[j]=temp;
//     }
        
         int indexToFind = nums.length - k;
        return quickselect(nums, 0, nums.length - 1, indexToFind);
    }

    private int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);
        
        if (pivotIndex == k) {
            return nums[pivotIndex]; 
        } else if (pivotIndex < k) {
            return quickselect(nums, pivotIndex + 1, right, k); 
        } else {
            return quickselect(nums, left, pivotIndex - 1, k); 
        }
    }

    private int partition(int[] nums, int left, int right) {
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotValue = nums[pivotIndex];
        
        swap(nums, pivotIndex, right);
        
        int storeIndex = left;
        
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
    
        swap(nums, storeIndex, right);
        
        return storeIndex; 
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}