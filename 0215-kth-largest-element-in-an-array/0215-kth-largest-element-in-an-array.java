class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> (b-a));
        for(int num : nums){
            maxPq.add(num);
        }
        for(int i =1;i<k;i++){
            maxPq.poll();
        }
        return maxPq.peek();
        
    }
}