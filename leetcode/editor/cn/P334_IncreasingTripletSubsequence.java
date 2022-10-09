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
        solution.increasingTriplet(new int[]{20,100,10,12,5,13});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int[] max = new int[3];
            Arrays.fill(max, Integer.MAX_VALUE);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < max.length; j++) {
                    if (nums[i] <= max[j]) {
                        if (j == 2) {
                            return true;
                        }
                        max[j] = nums[i];
                        break;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
