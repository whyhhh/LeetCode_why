package leetcode.editor.cn;

/**
 * 最长回文子序列
 *
 * @author why
 * @date 2022-11-15 22:24:40
 */
public class P516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new P516_LongestPalindromicSubsequence().new Solution();
        solution.longestPalindromeSubseq("bbbab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int[][] dp = new int[n][n];

            for (int len = 1; len <= n; len++) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    if (len == 1) {
                        dp[l][r] = 1;
                    } else if (len == 2) {
                        dp[l][r] = cs[l] == cs[r] ? 2 : 1;
                    } else {
                        dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                        dp[l][r] = Math.max(dp[l][r], dp[l + 1][r - 1] + (cs[l] == cs[r] ? 2 : 0));
                    }
                }
            }

            return dp[0][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}