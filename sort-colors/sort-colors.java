class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int middle = 0;
        int end = nums.length-1;
        while(middle<= end){
            switch(nums[middle]){
                case 0:
                swap(nums, middle, start);
                start++;
                middle++;
                break;
                case 1:
                middle++;
                break;
                case 2:
                swap(nums,middle, end);
                end--;
                break;
            }

        }
    }
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}