package leetcode.editor.cn;

/**
 * 区间子数组个数
 *
 * @author why
 * @date 2022-11-24 16:29:46
 */
public class P795_NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        Solution solution = new P795_NumberOfSubarraysWithBoundedMaximum().new Solution();
        solution.numSubarrayBoundedMax(new int[]{1, 3, 4, 2, 1, 7, 3, 1, 6, 8}, 2, 6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int a, int b) {
            int n = nums.length, ans = 0;
            for (int i = 0, j = -1, k = -1; i < n; i++) {
                if (nums[i] > b) {
                    k = i;
                } else {
                    if (nums[i] >= a) {
                        ans += i - k;
                        j = i;
                    } else {
                        if (j > k) {
                            ans += j - k;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}