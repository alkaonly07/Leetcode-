class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        
        s=s.replace(" ", "");
        t=t.replace(" ","");
        
        // s = s.replaceAll("\\s", "").toLowerCase();
        // t = t.replaceAll("\\s", "").toLowerCase();
        
        int[] count = new int[26];
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)- 'a']++;
            
        }
        for(int i=0;i<t.length();i++){
            count[t.charAt(i)- 'a']--;
        }
        for(int c: count){
            if(c!=0){
                return false;
            }
        }
        return true;
    }
    
}