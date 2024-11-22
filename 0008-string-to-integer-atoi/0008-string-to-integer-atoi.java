// class Solution {
//     public int myAtoi(String s) {
//         int n = s.length();
//         int i = 0;
//         int sign = 1;
//         long result = 0;
//         while(i<n && s.charAt(i)==' '){
//             i++;
//         }
//         while(i<n &&(s.charAt(i)=='-' || s.charAt(i)=='+')){
//             sign = (s.charAt(i)=='-')?-1:1;
//             i++;
//         }
//         while(i<n && Character.isDigit(s.charAt(i))){
//             int digit = s.charAt(i) - '0';
//             result = result*10 + digit;
//             if(result*sign> Integer.MAX_VALUE){
//                 return Integer.MAX_VALUE;
//             }
//             else if(result*sign < Integer.MIN_VALUE){
//                 return Integer.MIN_VALUE;
//             }
//             i++;
            
//         }
//         return (int) (result*sign);
//     }
// }
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;  // Default sign is positive
        long result = 0;  // Use long to detect overflow before converting to int
        
        // Step 1: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Handle optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';  // Convert char to integer
            result = result * 10 + digit;
            
            // Step 4: Check for overflow/underflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        
        // Step 5: Return the result with sign
        return (int) (result * sign);
    }
}
