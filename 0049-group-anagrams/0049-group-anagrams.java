class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!(map.containsKey(key))){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
                                     
        }
        
        return new ArrayList<>(map.values());
    }
}

//time : O(N * KlogK)
//space : O(N * K)
//N = number of Strings
//k = avg length of each string