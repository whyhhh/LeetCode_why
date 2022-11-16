package leetcode.editor.cn;

/**
 * 猜数字大小 II
 *
 * @author why
 * @date 2022-10-13 15:11:00
 */
public class P375_GuessNumberHigherOrLowerIi {
    public static void main(String[] args) {
        Solution solution = new P375_GuessNumberHigherOrLowerIi().new Solution();
        solution.getMoneyAmount(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n + 10][n + 10];
            for (int len = 2; len <= n; len++) {
                for (int l = 1; l + len - 1 <= n; l++) {
                    int r = l + len - 1;
                    dp[l][r] = 0x3f3f3f3f;
                    for (int i = l; i < r; i++) {
                        int cur = i + Math.max(dp[l][i - 1], dp[i + 1][r]);
                        dp[l][r] = Math.min(dp[l][r], cur);
                    }
                }
            }
            return dp[1][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


