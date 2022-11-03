package leetcode.editor.cn;

/**
 * 网络信号最好的坐标
 *
 * @author why
 * @date 2022-11-02 14:45:01
 */
public class P1620_CoordinateWithMaximumNetworkQuality {
    public static void main(String[] args) {
        Solution solution = new P1620_CoordinateWithMaximumNetworkQuality().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int x = 0, y = 0, max = 0;
            int[][] t = new int[110][110];
            for (int[] tower : towers) {
                int a = tower[0], b = tower[1], q = tower[2];
                for (int i = Math.max(0, a - radius); i <= a + radius; i++) {
                    for (int j = Math.max(0, b - radius); j <= b + radius; j++) {
                        double r = Math.sqrt((a - i) * (a - i) + (b - j) * (b - j));
                        if (r > radius) continue;
                        t[i][j] += Math.floor(q / (1 + r));
                        if (t[i][j] > max) {
                            x = i;
                            y = j;
                            max = t[i][j];
                        } else if (t[i][j] == max && (i < x || (i == x && j < y))) {
                            x = i;
                            y = j;
                        }

                    }
                }

            }
            return new int[]{x, y};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}