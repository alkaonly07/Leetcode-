class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck); 
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast()); 
            }
            deque.addFirst(deck[i]); 
        }
        int[] result = new int[n];
        int index = 0;
        for (int num : deque) {
            result[index++] = num;
        }
        
        return result;
    }
}