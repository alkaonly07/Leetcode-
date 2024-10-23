class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int current = 0;
        int jump = 0;
        if(nums.length <=1){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            farthest = Math.max(farthest,i+nums[i]);
            if(i == current){
                jump++;
                current = farthest;
                if(farthest >= nums.length-1){
                    return jump;
                }
            }
            
        }
        return 0;
        
    }
}