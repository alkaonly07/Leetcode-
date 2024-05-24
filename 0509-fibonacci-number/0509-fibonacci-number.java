
class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    public int fib(int n) {
        if(n<0 ){
            return -1;
        }
        if(n==0 ||n==1){
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // return fib(n-1)+fib(n-2);
         int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }
}