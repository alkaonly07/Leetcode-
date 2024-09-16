class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] newNums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            newNums[i]=nums[i]*nums[i];
        }
        Arrays.sort(newNums);
        return newNums;
        
    }
}