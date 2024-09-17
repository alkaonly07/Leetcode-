class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
        
    }
    private String buildString(String str){
        StringBuilder string = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(ch != '#'){
                string.append(ch);
            }
            else if(string.length()>0){
                string.deleteCharAt(string.length()-1);
            }
        
        }
        return string.toString();
    }
}