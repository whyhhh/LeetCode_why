package leetcode.editor.cn;

/**
 * 最长特殊序列 II
 *
 * @author why
 * @date 2022-11-25 11:13:42
 */
public class P522_LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new P522_LongestUncommonSubsequenceIi().new Solution();
        solution.findLUSlength(new String[]{});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            int ans = -1, n = strs.length;
            for (int i = 0; i < n; i++) {
                if (strs[i].length() <= ans) continue;
                boolean ok = true;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (check(strs[i], strs[j])) ok = false;
                }
                if (ok) ans = strs[i].length();
            }
            return ans;
        }

        private boolean check(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (m < n) return false;
            int[][] f = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    f[i][j] = f[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 : 0);
                    f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                    f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                    if (f[i][j] == n) return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}