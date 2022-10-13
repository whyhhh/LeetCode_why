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
        solution.getMoneyAmount(16);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[][] cache = new int[201][201];

        public int getMoneyAmount(int n) {
            return dfs(0, n);
        }

        int dfs(int l, int r) {
            if (l >= r) {
                return 0;
            }
            int ans = 0x3f3f3f3f;
            if (cache[l][r] != 0) return cache[l][r];
            for (int i = l; i < r; i++) {
                int cur = Math.max(dfs(l, i - 1), dfs(i + 1, r)) + i;
                ans = Math.min(ans, cur);
            }
            cache[l][r] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


