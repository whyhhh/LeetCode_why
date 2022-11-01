package leetcode.editor.cn;

/**
 * 跳跃游戏 II
 *
 * @author why
 * @date 2022-11-01 11:26:29
 */
public class P45_JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45_JumpGameIi().new Solution();
        solution.jump(new int[]{2, 3, 1, 1, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            for (int i = 1, j = 0; i < n; i++) {
                while (j + nums[j] < i) j++;
                f[i] = f[j] + 1;
            }
            return f[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}