class Solution {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen<pLen){
            return result;
        }
        int[] sFreq = new int[26];
        for(int i=0;i<pLen;i++){
            sFreq[s.charAt(i)-'a']++;
        }
        int[] pFreq = new int[26];
        for(char ch : p.toCharArray()){
            pFreq[ch - 'a']++;
        }
        for(int i=0;i<=sLen - pLen;i++){
            if(Arrays.equals(pFreq,sFreq)){
                result.add(i);
            }
            if(i+pLen < sLen){
                sFreq[s.charAt(i) - 'a']--;
                sFreq[s.charAt(i+pLen) - 'a']++;
            }
        }
        return result;
        
    }
}