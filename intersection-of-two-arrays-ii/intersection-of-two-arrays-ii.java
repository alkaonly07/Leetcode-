class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = getFreq(nums1);
        int[] freq2 = getFreq(nums2);  
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<freq1.length;i++){
            int count = Math.min(freq1[i],freq2[i]);
            while(count-- > 0){
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for(int  i =0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
    private int[] getFreq(int[] nums){
        int[] freq =  new int[1001];
        for(int num : nums){
            freq[num]++;
        }
        return freq;
    }
}