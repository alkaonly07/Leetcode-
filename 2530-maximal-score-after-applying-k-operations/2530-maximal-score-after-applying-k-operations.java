class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            maxHeap.add(i);
        }
        while(k-- > 0){
            int maxElement = maxHeap.poll();
            score += maxElement;
            maxHeap.add((int)Math.ceil(maxElement / 3.0));
        
        }
        return score;
        
    }
    // private int ceil(int num, int x){
    //     int div = num/x ;
    //     if(num%x != 0){
    //         div++;
    //     }
    //     return div;
    // }
    // private void findingMax(int[] nums){
    //     Arrays.sort(nums);
    // }
}