class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length ==1){
            return nums[nums.length-1];
        }
        int i=0;
        while(i<nums.length-1){
            
            if(nums[i] ==nums[i+1]){
                i++;
            }
            else{
                return nums[i];
            }
        
            i++;
            if(i== nums.length-1){
                return nums[i];
            }
            
        }
        return -1;
        
    }
}