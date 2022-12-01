package leetcode.editor.cn;

/**
 * 找到最近的有相同 X 或 Y 坐标的点
 *
 * @author why
 * @date 2022-12-01 09:13:40
 */
public class P1779_FindNearestPointThatHasTheSameXOrYCoordinate {
    public static void main(String[] args) {
        Solution solution = new P1779_FindNearestPointThatHasTheSameXOrYCoordinate().new Solution();
        solution.nearestValidPoint(3, 4, new int[][]{{1, 2}, {2, 4}, {4, 4}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int ans = -1, min = (int) 1e4 + 10, n = points.length;
            for (int i = 0; i < n; i++) {
                if (points[i][0] == x || points[i][1] == y) {
                    int num = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                    if (num < min) {
                        ans = i;
                        min = num;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}