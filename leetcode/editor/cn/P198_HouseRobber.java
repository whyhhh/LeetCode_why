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
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = nums[1];

            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1] - nums[i - 1] + nums[i]);
            }
            return Math.max(dp[n - 1], dp[n - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}