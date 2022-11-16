package leetcode.editor.cn;

/**
 * 奇怪的打印机
 *
 * @author why
 * @date 2022-11-16 11:15:52
 */
public class P664_StrangePrinter {
    public static void main(String[] args) {
        Solution solution = new P664_StrangePrinter().new Solution();
        solution.strangePrinter("aaaabbbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strangePrinter(String s) {
            int n = s.length();
            int[][] dp = new int[n + 1][n + 1];
            char[] cs = s.toCharArray();
            for (int len = 1; len <= n; len++) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    dp[l][r] = dp[l + 1][r] + 1;
                    for (int i = l + 1; i <= r; i++) {
                        if (cs[i] == cs[l]) dp[l][r] = Math.min(dp[l][r], dp[l][i - 1] + dp[i + 1][r]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}