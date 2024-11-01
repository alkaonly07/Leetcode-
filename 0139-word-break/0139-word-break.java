class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp= new boolean[n+1];
        dp[0] = true;
        int maxlength = 0;
        for(String word : wordDict){
            maxlength = Math.max(maxlength, word.length());
        }
        for(int i=0; i<=n; i++){
            for(int j=i-1; j>=0;j-- ){
                if(i-j > maxlength){
                    continue;
                }
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}