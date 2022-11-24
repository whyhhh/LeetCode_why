package leetcode.editor.cn;

/**
 * 摘樱桃
 *
 * @author why
 * @date 2022-11-23 17:21:39
 */
public class P741_CherryPickup {
    public static void main(String[] args) {
        Solution solution = new P741_CherryPickup().new Solution();
        solution.cherryPickup(new int[][]{
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int N = 55, INF = Integer.MIN_VALUE;
        static int[][][] f = new int[2 * N][N][N];

        public int cherryPickup(int[][] g) {
            int n = g.length;
            for (int k = 0; k <= 2 * n; k++) {
                for (int i1 = 0; i1 <= n; i1++) {
                    for (int i2 = 0; i2 <= n; i2++) {
                        f[k][i1][i2] = INF;
                    }
                }
            }
            f[2][1][1] = g[0][0];
            for (int k = 3; k <= 2 * n; k++) {
                for (int i1 = 1; i1 <= n; i1++) {
                    for (int i2 = 1; i2 <= n; i2++) {
                        //计算连点纵坐标
                        int j1 = k - i1, j2 = k - i2;
                        if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) continue;
                        // 当前两点有障碍，则跳过
                        int A = g[i1 - 1][j1 - 1], B = g[i2 - 1][j2 - 1];
                        if (A == -1 || B == -1) continue;
                        //两点位移的四种情况中
                        int a = f[k - 1][i1 - 1][i2], b = f[k - 1][i1 - 1][i2 - 1], c = f[k - 1][i1][i2 - 1], d = f[k - 1][i1][i2];
                        int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;
                        if (i1 != i2) t += B;
                        f[k][i1][i2] = t;
                    }
                }
            }
            return Math.max(f[2 * n][n][n], 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}