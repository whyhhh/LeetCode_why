package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 堆叠长方体的最大高度
 *
 * @author why
 * @date 2022-12-10 16:25:04
 */
public class P1691_MaximumHeightByStackingCuboids {
    public static void main(String[] args) {
        Solution solution = new P1691_MaximumHeightByStackingCuboids().new Solution();
        solution.maxHeight(new int[][]{{7,10,17},{7,16,11},{16,5,17},{11,4,7},{17,3,11},{17,1,7}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxHeight(int[][] cuboids) {
            for (int[] c : cuboids) Arrays.sort(c);
            //箱子从小到大排序
            Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

            int ans = 0, n = cuboids.length;
            int[] f = new int[n];
            for (int i = 0; i < n; ++i) {
                //是否有箱子能叠放到i上
                for (int j = 0; j < i; ++j) {
                    // cuboids[j] 可以堆在 cuboids[i] 上
                    if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                        f[i] = Math.max(f[i], f[j]);
                    }
                }
                f[i] += cuboids[i][2];
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}