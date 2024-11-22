class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        long result = 0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i<n &&(s.charAt(i)=='-' || s.charAt(i)=='+')){
            sign = (s.charAt(i)=='-')?-1:1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            result = result*10 + digit;
            if(result*sign> Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if(result*sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
            
        }
        return (int) (result*sign);
    }
}