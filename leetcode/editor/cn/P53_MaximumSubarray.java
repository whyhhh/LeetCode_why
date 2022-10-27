package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * 最大子数组和
 *
 * @author why
 * @date 2022-10-27 16:47:46
 */
public class P53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53_MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int n = nums.length;
            int cur = nums[0];
            for (int i = 1; i < n; i++) {
                cur = Math.max(cur + nums[i], nums[i]);
                ans = Math.max(cur, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}