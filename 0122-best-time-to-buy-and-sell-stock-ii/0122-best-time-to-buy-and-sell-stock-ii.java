class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = Integer.MAX_VALUE;
        int sum = 0;
        for (int price : prices) {
            if (price >= maxVal) {
                sum += price - maxVal;
            }
            maxVal = price;
        }
        return sum;
        
    }
}