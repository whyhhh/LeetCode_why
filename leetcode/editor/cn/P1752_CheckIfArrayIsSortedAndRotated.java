package leetcode.editor.cn;

/**
 * 检查数组是否经排序和轮转得到
 *
 * @author why
 * @date 2022-11-28 16:56:56
 */
public class P1752_CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        Solution solution = new P1752_CheckIfArrayIsSortedAndRotated().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean check(int[] nums) {
            int n = nums.length, t = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) t++;
                if (t > 1) return false;
            }
            return t == 0 || nums[0] >= nums[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}