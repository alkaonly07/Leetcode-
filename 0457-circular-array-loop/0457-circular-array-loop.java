class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length<=1){
            return false;
        }
        int n=nums.length;
        for(int i=0;i<n;i++){
            int slow = i;
            int fast = i;
            boolean ifForward = nums[i]>0;
            while(true){
                slow = getNextPosition(nums, slow, ifForward);
                if(slow == -1){
                    break;
                }
                fast = getNextPosition(nums, fast, ifForward);
                if(fast == -1){
                    break;
                }
                fast = getNextPosition(nums, fast, ifForward);
                if(fast == -1){
                    break;
                }
                if(slow == fast){
                    return true;
                }
                
            }
        }
        return false;
        
    }
    private int getNextPosition(int[] nums, int index, boolean ifForward){
        boolean direction = nums[index]>=0;
        if(direction != ifForward){
            return -1;
        }
        int nextIndex = (index + nums[index]) % nums.length;
        
        if(nextIndex < 0){
            nextIndex = nextIndex + nums.length;
        }
        if(nextIndex == index){
            return -1;
        }
        return nextIndex;
        
    }
}