class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
            if(n==Integer.MIN_VALUE){
                n=Integer.MAX_VALUE;
                return x * helper(x, n);
            }
            else{
                n=-n;
            }
        }
        return helper(x,n);
        
    }
    public double helper(double x, int n){
      if(n==0){
            return 1;
        }
        double half=helper(x,n/2);
        if(n%2==0){
           return half*half; 
        }
        else{
            return half*half*x;
        }
    }
}