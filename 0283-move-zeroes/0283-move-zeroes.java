class Solution {
    public void moveZeroes(int[] nums) {
        int  first = 0;
        for(int second = 0;second<nums.length; second++){
            if(nums[second] != 0){
                int temp= nums[first];
                nums[first] = nums[second];
                nums[second]= temp;
                first++;
            }
        }
    }
    
}