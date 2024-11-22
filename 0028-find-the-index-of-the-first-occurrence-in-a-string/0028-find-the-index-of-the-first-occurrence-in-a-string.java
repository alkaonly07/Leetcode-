class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        char[] newNeedle = needle.toCharArray();
        char[] newHaystack = haystack.toCharArray();

            for(int j=0;j<=newHaystack.length - newNeedle.length;j++){
                if(newNeedle[0] ==newHaystack[j]){
                    
                    for(int i =0;i<newNeedle.length;i++){
                        if(newNeedle[i] != newHaystack[i+j] ){
                            index=-1;
                            break;
                        }
                        index= j;
 
                    }
                    if(index>-1){
                        break;
                    }
                }      
        }
        return index;
        
    }
}