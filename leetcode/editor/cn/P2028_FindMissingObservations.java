package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 找出缺失的观测数据
 *
 * @author why
 * @date 2022-12-10 23:07:40
 */
public class P2028_FindMissingObservations {
    public static void main(String[] args) {
        Solution solution = new P2028_FindMissingObservations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length, sum = (n + m) * mean;
            int[] ans = new int[n];
            for (int i = 0; i < m; i++) sum -= rolls[i];

            if (sum < n || sum > n * 6) return new int[0];

            int num = sum / n;
            sum -= num * n;
            Arrays.fill(ans, num);
            while (sum-- > 0) ans[--n]++;

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}