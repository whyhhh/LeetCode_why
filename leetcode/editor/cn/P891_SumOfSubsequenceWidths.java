package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 子序列宽度之和
 *
 * @author why
 * @date 2022-11-21 11:05:47
 */
public class P891_SumOfSubsequenceWidths {
    public static void main(String[] args) {
        Solution solution = new P891_SumOfSubsequenceWidths().new Solution();
        solution.sumSubseqWidths(new int[]{2, 1, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) 1e9 + 7;

        public int sumSubseqWidths(int[] nums) {
            Arrays.sort(nums);
            long res = 0;
            long x = nums[0], y = 2;
            for (int j = 1; j < nums.length; j++) {
                res = (res + nums[j] * (y - 1) - x) % MOD;

                x = (x * 2 + nums[j]) % MOD;
                y = y * 2 % MOD;
            }
            return (int) ((res + MOD) % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}