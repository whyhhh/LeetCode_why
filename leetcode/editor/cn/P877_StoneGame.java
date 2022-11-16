package leetcode.editor.cn;

/**
 * 石子游戏
 *
 * @author why
 * @date 2022-11-16 15:39:05
 */
public class P877_StoneGame {
    public static void main(String[] args) {
        Solution solution = new P877_StoneGame().new Solution();
        solution.stoneGame(new int[]{1, 4, 3, 5, 2, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n + 2][n + 2];

            for (int len = 1; len <= n; len++) {
                for (int l = 1; l + len - 1 <= n; l++) {
                    int r = l + len - 1;
                    //拿最左边的石头堆
                    int a = piles[l-1] - dp[l + 1][r];
                    //拿右边的石头堆
                    int b = piles[r-1] - dp[l][r - 1];
                    dp[l][r] = Math.max(a, b);
                }
            }
            return dp[1][n] > 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}