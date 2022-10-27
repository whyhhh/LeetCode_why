package leetcode.editor.cn;

/**
 * 跳跃游戏
 *
 * @author why
 * @date 2022-10-27 17:25:34
 */
public class P55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55_JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) return true;
            if (nums[0] == 0) return false;
            int n = nums.length;
            int gap = nums[0];
            for (int i = 1; i < n; i++) {
                if (gap == 0) return false;
                gap--;
                gap = Math.max(gap, nums[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}