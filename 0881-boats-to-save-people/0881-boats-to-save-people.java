class Solution {
    public int numRescueBoats(int[] people, int limit) {
      Arrays.sort(people);
        int start = 0;
        int end = people.length - 1; // Use end pointer to traverse from the end of the sorted array
        int count = 0;

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++; // If both lightest and heaviest person can fit, increment start pointer
            }
            end--; // Increment end pointer regardless, since heaviest person tried to fit or not
            count++; // Increment count for each boat
        }
        return count;
    }
}