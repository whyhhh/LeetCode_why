package leetcode.editor.cn;

/**
 * 骑士在棋盘上的概率
 *
 * @author why
 * @date 2022-12-14 14:00:45
 */
public class P688_KnightProbabilityInChessboard {
    public static void main(String[] args) {
        Solution solution = new P688_KnightProbabilityInChessboard().new Solution();
        solution.knightProbability(3, 2, 0, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //8个方向
        int[][] dirs = new int[][]{{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, 1}, {-2, -1}, {2, 1}, {2, -1}};

        public double knightProbability(int n, int k, int row, int column) {
            double[][][] f = new double[n][n][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j][0] = 1;
                }
            }
            for (int p = 1; p <= k; p++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int[] d : dirs) {
                            int nx = i + d[0], ny = j + d[1];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            f[i][j][p] += f[nx][ny][p - 1] / 8;
                        }
                    }
                }
            }
            return f[row][column][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}