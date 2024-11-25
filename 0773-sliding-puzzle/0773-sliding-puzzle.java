// class Solution {
//     public int slidingPuzzle(int[][] board) {
//         String target = "123450";
//         String start = boardString(board);
//         int[][] direction = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
//         Queue<String> q = new LinkedList<>();
//         Set<String> visited = new HashSet<>();
//         visited.add(start);
//         q.offer(start);
//         int count = 0;
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0;i<size;i++){
//                 String current  = q.poll();
//                 if(current.equals(target)){
//                     return count;
//                 }
//                 int zeroIndex = current.indexOf('0');
//                 for(int dir : direction[zeroIndex]){
//                     String nextString = swap(current, zeroIndex, dir);
//                     if(!visited.contains(nextString)){
//                         visited.add(nextString);
//                         q.offer(nextString);  
//                     }
//                 }
                
//             }
//             count++;       
//         }
//         return count;
//     }
//     private String boardString(int[][] board){
//         StringBuilder s = new StringBuilder();
//         for(int[] arr : board){
//             for(int num : arr){
//                 s.append(num);
//             }
//         }
//         return s.toString();
//     }
//     private String swap(String s, int i, int j){
//         char[] ch = s.toCharArray();
//         char temp = ch[i];
//         ch[i] = ch[j];
//         ch[j] = temp;
//         return new String(ch);
//     }
// }

import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = boardToString(board);
        
        // Directions for moving tiles: left, right, up, down
        int[][] directions = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return moves;
                
                int zeroIndex = current.indexOf('0');
                for (int dir : directions[zeroIndex]) {
                    String nextState = swap(current, zeroIndex, dir);
                    if (!visited.contains(nextState)) {
                        queue.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
            moves++;
        }
        
        return -1; // No solution found
    }
    
    // Helper to convert board to string
    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
    
    // Swap characters in the string
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
