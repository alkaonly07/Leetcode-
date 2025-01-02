class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target);
        int right= rightBound(nums,target);
        return new int[]{left,right}; 
    }
    private int leftBound(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid  =  start+(end-start)/2;
            if(nums[mid]>target){
                end = mid-1;
            }
            else if(nums[mid]<target){
                start = mid+1;
            }
            else{
                index = mid;
                end = mid-1;
            }
        }
        return index;
        
    }
    private int rightBound(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid  =  start+(end-start)/2;
            if(nums[mid]>target){
                end = mid-1;
            }
            else if(nums[mid]<target){
                start = mid+1;
            }
            else{
                index = mid;
                start= mid+1;
            }
        }
        return index;
        
    }
}