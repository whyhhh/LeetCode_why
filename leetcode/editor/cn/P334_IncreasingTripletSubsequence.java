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
            int a = 0, b = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[a]) {
                    if (b == 0) {
                        b = i;
                    } else {
                        if (nums[i] > nums[b]) {
                            return true;
                        } else {
                            b = i;
                        }
                    }
                } else {
                    a = i;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
