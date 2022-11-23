package leetcode.editor.cn;

import java.util.OptionalDouble;

/**
 * 多米诺和托米诺平铺
 *
 * @author why
 * @date 2022-11-23 14:14:40
 */
public class P790_DominoAndTrominoTiling {
    public static void main(String[] args) {
        Solution solution = new P790_DominoAndTrominoTiling().new Solution();
        solution.numTilings(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) (1e9 + 7);

        public int numTilings(int n) {
            int[][] f = new int[n + 10][4];
            f[1][0] = f[1][1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i][0] = f[i - 1][1];
                int cur = 0;
                for (int j = 0; j < 4; j++) cur = (cur + f[i - 1][j]) % mod;
                f[i][1] = cur;
                f[i][2] = (f[i - 1][0] + f[i - 1][3]) % mod;
                f[i][3] = (f[i - 1][0] + f[i - 1][2]) % mod;
            }
            return f[n][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}