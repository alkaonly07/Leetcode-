class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MAX_VALUE;
        int sum = 0;
        for(int price : prices){
            if(price>=max){
                sum += price-max;
            }
            max = price;
        }
        return sum;
    }
}