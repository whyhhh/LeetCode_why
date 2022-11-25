package leetcode.editor.cn;

/**
 * 子数组范围和
 *
 * @author why
 * @date 2022-11-25 10:15:12
 */
public class P2104_SumOfSubarrayRanges {
    public static void main(String[] args) {
        Solution solution = new P2104_SumOfSubarrayRanges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long subArrayRanges(int[] nums) {
            int n = nums.length;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int min = nums[i], max = nums[i];
                for (int j = i + 1; j < n; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    ans += max - min;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}