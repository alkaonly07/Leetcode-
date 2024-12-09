class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length==0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = getFrequency(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            else{
                List<String> s1 = new ArrayList<>();
                s1.add(s);
                map.put(key, s1);
            }
           
        }
    
         return new ArrayList<>(map.values());
    }
        
    
    private String getFrequency(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for(int i : freq){
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
}