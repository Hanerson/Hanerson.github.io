package classic150;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t){
        if(s.isEmpty()) return true;
        if(t.isEmpty()) return false;
        if(s.length() > t.length()) return false;
        int pos_s = 0, pos_t = 0;
        while(pos_t < t.length()){
            if(s.charAt(pos_s) == t.charAt(pos_t)){
                pos_s++;
                if(pos_t == t.length() - 1) return true;
            }
            pos_t++;
        }
        return false;
    }

    public boolean isSubsequence_dp(String s, String t) {
        int m = s.length(), n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int j = 0; j <= n; j++) dp[0][j] = true;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

}
