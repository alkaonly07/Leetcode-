class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num : nums){
            add(num);
        }
        
    }
    
    public int add(int val) {
        if(pq.size()<k || pq.peek()<val){
            pq.offer(val);
             if(pq.size() > k){
                 pq.remove();
        }
        }
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */