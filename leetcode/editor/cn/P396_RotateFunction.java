package leetcode.editor.cn;

/**
 * 旋转函数
 *
 * @author why
 * @date 2022-12-02 18:00:14
 */
public class P396_RotateFunction {
    public static void main(String[] args) {
        Solution solution = new P396_RotateFunction().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int n = nums.length, sum = 0, cur = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                cur += (i * nums[i]);
            }
            ans = cur;
            for (int i = 1; i < n; i++) {
                cur = cur + sum - nums[n - i] * n;
                ans = Math.max(cur, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}