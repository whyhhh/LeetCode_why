package leetcode.editor.cn;

/**
 * 最短的桥
 *
 * @author why
 * @date 2022-10-25 10:09:51
 */
public class P934_ShortestBridge {
    public static void main(String[] args) {
        Solution solution = new P934_ShortestBridge().new Solution();
        solution.shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        boolean[][] flag;
        int[][] grid;
        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int shortestBridge(int[][] grid) {
            int ans = 0;
            n = grid.length;
            this.grid = grid;
            flag = new boolean[n][n];


            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (grid[x][y] == 1 && !flag[x][y]) {
                        init(x, y, 2);
                        flag = new boolean[n][n];
                        while (!bfs(x, y)) {
                            flag = new boolean[n][n];
                            ans++;
                        }
                        return ans;
                    }
                }
            }
            return 0;
        }

        private void init(int x, int y, int nun) {
            flag[x][y] = true;
            grid[x][y] = nun;
            for (int[] move : moves) {
                int i = x + move[0];
                int j = y + move[1];
                if (check(i, j) && !flag[i][j] && grid[i][j] == 1) {
                    init(i, j, nun);
                }
            }
        }

        private boolean bfs(int x, int y) {
            boolean b = false;
            for (int[] move : moves) {
                int i = x + move[0];
                int j = y + move[1];
                //下一步还在岛上
                if (check(i, j) && !flag[i][j] && grid[i][j] == 2) {
                    flag[i][j] = true;
                    b = b | bfs(i, j);
                    //下一步在海上
                } else if (check(i, j) && !flag[i][j] && grid[i][j] == 0) {
                    flag[i][j] = true;
                    grid[i][j] = 2;
                    //下一步上岛了
                } else if (check(i, j) && grid[i][j] == 1) {
                    b = true;
                }
            }
            return b;
        }

        private boolean check(int x, int y) {
            return x >= 0 && x < n && y >= 0 && y < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}