class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for(int end = 0 ; end < s.length() ; end++){
            char current = s.charAt(end);
            if(map.containsKey(current) && map.get(current) >= start){
                start = map.get(current)+1;
            }
            map.put(current, end);
            max = Math.max(max, end-start+1);
        }
        return max;
        
    }
}