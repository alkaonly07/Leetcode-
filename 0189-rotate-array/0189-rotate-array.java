class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0 , k-1);
        reverse(nums, k, nums.length-1);
        
    }
    private void reverse(int[] num, int i, int j){
        
        while(i<j){
           int temp =  num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }
}