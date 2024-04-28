class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> s= new ArrayList<>();
        int k=0;
        for(int i=1;i<=target[target.length-1];i++){
            s.add("Push");
            if(i!=target[k]){
                s.add("Pop");
            }
           else  k++;
        }  
        return s;
    }
}