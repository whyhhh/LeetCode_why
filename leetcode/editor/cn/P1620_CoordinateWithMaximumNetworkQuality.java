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
            int[][] temp = new int[110][110];
            for (int[] tower : towers) {
                int a = tower[0], b = tower[1], q = tower[2];
                for (int i = Math.max(a - radius, 0); i <= a + radius; i++) {
                    for (int j = Math.max(b - radius, 0); j <= b + radius; j++) {
                        double sqrt = Math.sqrt((a - i) * (a - i) + (b - j) * (b - j));
                        if (sqrt > radius) continue;
                        temp[i][j] += q / (1 + sqrt);
                        if (max < temp[i][j]) {
                            x = i;
                            y = j;
                            max = temp[i][j];
                        } else if (max == temp[i][j] && ((i < x) || (i == x && j < y))) {
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