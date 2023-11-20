package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 检查边长度限制的路径是否存在
 *
 * @author why
 * @date 2022-12-14 11:05:17
 */
public class P1697_CheckingExistenceOfEdgeLengthLimitedPaths {
    public static void main(String[] args) {
        Solution solution = new P1697_CheckingExistenceOfEdgeLengthLimitedPaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
         int N = 100010;
         int[] p = new int[N];

        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }

        boolean query(int a, int b) {
            return find(a) == find(b);
        }

        public boolean[] distanceLimitedPathsExist(int n, int[][] es, int[][] _qs) {
            for (int i = 0; i < n; i++) p[i] = i;
            int m = es.length, k = _qs.length;
            int[][] qs = new int[k][4];
            for (int i = 0; i < k; i++) qs[i] = new int[]{_qs[i][0], _qs[i][1], _qs[i][2], i};
            Arrays.sort(qs, (a, b) -> a[2] - b[2]);
            Arrays.sort(es, (a, b) -> a[2] - b[2]);
            boolean[] ans = new boolean[k];
            for (int i = 0, j = 0; i < k; i++) {
                int a = qs[i][0], b = qs[i][1], t = qs[i][2], idx = qs[i][3];
                while (j < m && es[j][2] < t) {
                    union(es[j][0], es[j][1]);
                    j++;
                }
                ans[idx] = query(a, b);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}