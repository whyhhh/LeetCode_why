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
            if (n == 2) return Math.max(nums[0], nums[1]);
            int ans1, ans2;

            int[][] f = new int[n][2];
            f[0][0] = nums[0];
            for (int i = 1; i < n - 1; i++) {
                f[i][0] = f[i - 1][1] + nums[i];
                f[i][1] = Math.max(f[i - 1][0], f[i - 1][1]);
            }
            ans1 = Math.max(f[n - 2][0], f[n - 2][1]);

            f = new int[n][2];
            f[1][0] = nums[1];
            for (int i = 2; i < n; i++) {
                f[i][0] = f[i - 1][1] + nums[i];
                f[i][1] = Math.max(f[i - 1][0], f[i - 1][1]);
            }
            ans2 = Math.max(f[n - 1][0], f[n - 1][1]);

            return Math.max(ans1, ans2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}