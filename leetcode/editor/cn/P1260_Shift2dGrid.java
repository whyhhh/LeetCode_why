package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * 二维网格迁移
 *
 * @author why
 * @date 2022-12-10 17:04:07
 */
public class P1260_Shift2dGrid {
    public static void main(String[] args) {
        Solution solution = new P1260_Shift2dGrid().new Solution();
        solution.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] g, int k) {
            int n = g.length, m = g[0].length;
            int[][] mat = new int[n][m];
            //旋转后的二位网格
            for (int i = 0; i < m; i++) {
                int tcol = (i + k) % m, trow = ((i + k) / m) % n, idx = 0;
                while (idx != n) mat[(trow++) % n][tcol] = g[idx++][i];
            }
            //放入list
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> alist = new ArrayList<>();
                for (int j = 0; j < m; j++) alist.add(mat[i][j]);
                ans.add(alist);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}