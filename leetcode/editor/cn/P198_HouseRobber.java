package leetcode.editor.cn;

/**
 * 打家劫舍
 *
 * @author why
 * @date 2022-11-14 16:46:33
 */
public class P198_HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198_HouseRobber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            if (n == 2) return Math.max(nums[0], nums[1]);
            int[][] dp = new int[n][2];
            //0：偷当前，1：不偷当前
            dp[0][0] = nums[0];
            dp[0][1] = 0;
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][1] + nums[i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }

            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}