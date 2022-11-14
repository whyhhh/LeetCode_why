package leetcode.editor.cn;

import java.time.Year;

/**
 * 不同的子序列
 *
 * @author why
 * @date 2022-11-14 14:01:40
 */
public class P115_DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new P115_DistinctSubsequences().new Solution();
        solution.numDistinct("rabbbit", "rabbit");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            s = " " + s;
            t = " " + t;
            int n = s.length(), m = t.length();
            int[][] dp = new int[n][m];
            char[] cs = s.toCharArray(), ct = t.toCharArray();

            for (int i = 0; i < n; i++) dp[i][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (cs[i] == ct[j]) dp[i][j] += dp[i - 1][j - 1];
                }
            }
            return dp[n-1][m-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}