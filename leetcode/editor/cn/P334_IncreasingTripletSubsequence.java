package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 递增的三元子序列
 *
 * @author why
 * @date 2022-09-29 14:49:55
 */
public class P334_IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution solution = new P334_IncreasingTripletSubsequence().new Solution();
        solution.increasingTriplet(new int[]{6, 7, 1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int n = nums.length;
            long[] f = new long[2];
            f[0] = f[1] = (long) 1e19;
            for (int i = 0; i < n; i++) {
                int cur = nums[i];
                if (cur > f[1]) return true;
                else if (f[0] < cur && cur < f[1]) f[1] = cur;
                else if (f[0] > cur) f[0] = cur;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
