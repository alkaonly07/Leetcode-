class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE; // Make n positive
                return x * helper(x, n); // Multiply by an extra x because we changed n to MAX_VALUE
            } else {
                n = -n;
            }
        }
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}