class Solution {
    public int secondHighest(String s) {
        
        int largest = -1;
        int secondLargest = -1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';

                if (digit > largest) {
                    // Update second largest before updating largest
                    secondLargest = largest;
                    largest = digit;
                } else if (digit > secondLargest && digit < largest) {
                    // Update second largest if it's smaller than largest but greater than secondLargest
                    secondLargest = digit;
                }
            }
        }

        return secondLargest;
        
    }
}