package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 获取所有钥匙的最短路径
 *
 * @author why
 * @date 2022-11-28 16:06:19
 */
public class P864_ShortestPathToGetAllKeys {
    public static void main(String[] args) {
        Solution solution = new P864_ShortestPathToGetAllKeys().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //最大长度、钥匙数，无穷大
         int N = 35, K = 6, INF = 0x3f3f3f3f;

         int[][][] dist = new int[N][N][1 << K];
        //方向坐标
         int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int shortestPathAllKeys(String[] g) {
            int n = g.length, m = g[0].length(), cnt = 0;
            Deque<int[]> d = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Arrays.fill(dist[i][j], INF);
                    char c = g[i].charAt(j);
                    if (c == '@') {
                        d.addLast(new int[]{i, j, 0});
                        dist[i][j][0] = 0;
                    } else if (c >= 'a' && c <= 'z') cnt++;
                }
            }
            while (!d.isEmpty()) {
                int[] info = d.pollFirst();
                int x = info[0], y = info[1], cur = info[2], step = dist[x][y][cur];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    char c = g[nx].charAt(ny);
                    if (c == '#') continue;
                    if ((c >= 'A' && c <= 'Z') && (cur >> (c - 'A') & 1) == 0) continue;
                    int ncur = cur;
                    if (c >= 'a' && c <= 'z') ncur |= 1 << (c - 'a');
                    if (ncur == (1 << cnt) - 1) return step + 1;
                    if (step + 1 >= dist[nx][ny][ncur]) continue;
                    dist[nx][ny][ncur] = step + 1;
                    d.addLast(new int[]{nx, ny, ncur});
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}