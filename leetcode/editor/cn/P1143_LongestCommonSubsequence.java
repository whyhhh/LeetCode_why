package leetcode.editor.cn;

/**
 * 最长公共子序列
 *
 * @author why
 * @date 2022-11-22 15:43:18
 */
public class P1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new P1143_LongestCommonSubsequence().new Solution();
        solution.longestCommonSubsequence("asdasf", "ffasda");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length(), m = text2.length();
            text1 = " " + text1;
            text2 = " " + text2;
            char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
            int[][] f = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (c1[i] == c2[j]) f[i][j] = f[i - 1][j - 1] + 1;
                    else f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
            return f[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}