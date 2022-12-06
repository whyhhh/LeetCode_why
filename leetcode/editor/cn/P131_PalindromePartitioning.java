package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 *
 * @author why
 * @date 2022-12-06 23:20:36
 */
public class P131_PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131_PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            // f[i][j] 代表 [i, j] 这一段是否为回文串
            boolean[][] f = new boolean[n][n];
            for (int len = 1; len <= n; len++) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    if (len == 1) {
                        f[l][r] = true;
                    } else if (len == 2) {
                        f[l][r] = cs[l] == cs[r];
                    } else {
                        f[l][r] = cs[l] == cs[r] && f[l + 1][r - 1];
                    }
                }
            }

            List<List<String>> ans = new ArrayList<>();
            List<String> cur = new ArrayList<>();
            dfs(s, 0, ans, cur, f);
            return ans;
        }

        /**
         * s: 要搜索的字符串
         * u: 以 s 中的那一位作为回文串分割起点
         * ans: 最终结果集
         * cur: 当前结果集
         * f: 快速判断 [i,j] 是否为回文串
         */
        void dfs(String s, int idx, List<List<String>> ans, List<String> cur, boolean[][] f) {
            int n = s.length();
            if (idx == n) ans.add(new ArrayList<>(cur));
            for (int i = idx; i < n; i++) {
                if (f[idx][i]) {
                    cur.add(s.substring(idx, i + 1));
                    dfs(s, i + 1, ans, cur, f);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}