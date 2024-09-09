class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longestSeq = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentSeq = 1;
                while(set.contains(currentNum+1)){
                    currentSeq++;
                    currentNum++; 
                }
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }
        return longestSeq;
    }
}