class Solution {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length()-1;
        int p2 = t.length()-1;
        while(p1>=0 || p2>=0){
            p1=getnextCh(s,p1);
            p2=getnextCh(t,p2);
            if(p1>=0 && p2>=0 && s.charAt(p1)!= t.charAt(p2)){
                return false;
            }
             if ((p1 >= 0) != (p2 >= 0)) {
                return false;
            }
            
            p1--;
            p2--;
        }
        return true;
        
    }
    private int getnextCh(String s, int index){
        int backspace = 0;
        while(index>=0){
            if(s.charAt(index)=='#'){
                backspace++;
            }
            else {
                if(backspace>0){
                    backspace--;
            }
                else{
                    break;
                }
            }
            index--;
        }
        return index;
    }
}