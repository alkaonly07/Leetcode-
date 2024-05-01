class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch); 
        if (index != -1) {
            return reverse(word.substring(0, index + 1)) + word.substring(index + 1);
        }
        return word;
    }
    
    private String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    
}