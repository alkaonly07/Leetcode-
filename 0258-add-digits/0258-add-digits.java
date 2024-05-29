class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = sumDigits(num);
        return addDigits(sum);
    }
    
    private int sumDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num % 10 + sumDigits(num / 10);
        }
    }
}
