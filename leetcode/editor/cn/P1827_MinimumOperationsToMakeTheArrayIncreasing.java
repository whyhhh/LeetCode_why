package leetcode.editor.cn;

/**
 * 最少操作使数组递增
 *
 * @author why
 * @date 2022-12-11 18:58:21
 */
public class P1827_MinimumOperationsToMakeTheArrayIncreasing {
    public static void main(String[] args) {
        Solution solution = new P1827_MinimumOperationsToMakeTheArrayIncreasing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int n = nums.length, ans = 0;
            if (n == 1) return ans;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) continue;
                ans += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}