package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 打家劫舍 II
 *
 * @author why
 * @date 2022-11-14 17:44:49
 */
public class P213_HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new P213_HouseRobberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            int[][] dp = new int[n][2];
            int res1, res2;

            //第一间选了
            //0：偷，1：没偷
            dp[0][0] = nums[0];
            dp[0][1] = 0;
            for (int i = 1; i < n - 1; i++) {
                dp[i][0] = dp[i - 1][1] + nums[i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
            res1 = Math.max(dp[n - 2][0], dp[n - 2][1]);

            //第一间没选
            //0：偷，1：没偷
            dp[0][0] = 0;
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][1] + nums[i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
            res2 = Math.max(dp[n - 1][0], dp[n - 1][1]);


            return Math.max(res1, res2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}