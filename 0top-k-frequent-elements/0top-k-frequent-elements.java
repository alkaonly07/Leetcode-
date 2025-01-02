class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap =  new HashMap<>();
        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(bucket[frequency]  == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for(int  i = bucket.length-1; i>=0 && result.size()<k;i--){
           if( bucket[i]!=null){
               result.addAll(bucket[i]);
           }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}