class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            maxHeap.add(i);
        }
        while(k-- >0){
            int element = maxHeap.poll();
            score += element;
            maxHeap.add((int)Math.ceil(element/3.0));
        }
        return score;
        
    }
}