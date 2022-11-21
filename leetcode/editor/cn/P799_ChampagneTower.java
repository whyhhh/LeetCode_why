package leetcode.editor.cn;

/**
 * 香槟塔
 *
 * @author why
 * @date 2022-11-21 10:26:38
 */
public class P799_ChampagneTower {
    public static void main(String[] args) {
        Solution solution = new P799_ChampagneTower().new Solution();
        solution.champagneTower(2, 1, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double champagneTower(int poured, int n, int m) {
            double[][] dp = new double[n + 10][n+10];
            dp[0][0] = poured;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (dp[i][j] <= 1) continue;
                    dp[i + 1][j] += (dp[i][j] - 1) / 2;
                    dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
                }
            }
            return Math.min(1, dp[n][m]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}