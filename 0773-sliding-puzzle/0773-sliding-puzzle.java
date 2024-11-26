class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = boardToString(board);
         int[][] directions = new int[][] {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 1, 3, 5 },
            { 2, 4 },
        };
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                String current = q.poll();
                if(current.equals(target)){
                    return moves;  
                }
                int zeroIndex = current.indexOf('0');
                for(int dir : directions[zeroIndex]){
                    String next = swap(current, zeroIndex, dir);
                    if(!visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                    
                }
            }
            moves++;
        }
        return -1;
        
    }
    private String boardToString(int[][] board){
        StringBuilder s = new StringBuilder();
        for(int[] arr : board){
            for(int num : arr){
                s.append(num);
            }
        }
        return s.toString();
    }
    private String swap(String current, int i, int j){
        char[] ch = current.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}