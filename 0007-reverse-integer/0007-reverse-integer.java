class Solution {
    public int reverse(int x) {
        int newX = 0;
        while(x!=0){
            int y=x%10;
            x=x/10;
            if(newX > Integer.MAX_VALUE/10 || (newX == Integer.MAX_VALUE/10 &&  y>7)){
                return 0;
            }
            if (newX < Integer.MIN_VALUE / 10 || (newX == Integer.MIN_VALUE / 10 && y < -8)) {
                return 0; // Underflow
            }
            newX= newX*10+ y ;
        }
        
        return newX;
        
        
    }
}