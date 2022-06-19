class Solution {
    public int minimumNumbers(int num, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = k; i <= num; i += 10){
            list.add(i);
        }
        
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        
        dp[0] = 0;
        
        for(int i = 1; i < num + 1; i++){
            for(Integer x : list){
                if(i - x >= 0 && dp[i-x] != -1){
                    if(dp[i] == -1){
                        dp[i] = 1 + dp[i-x];
                    }else{
                        dp[i] = Math.min(dp[i], 1 + dp[i-x]);
                    }
                }
            }
        }
        
        return dp[num];
    }
    
}
