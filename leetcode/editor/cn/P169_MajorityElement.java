package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 *
 * @author why
 * @date 2022-10-27 14:32:02
 */
public class P169_MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169_MajorityElement().new Solution();
        solution.majorityElement(new int[]{1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length, count = 1, flag = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] == flag) {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    flag = nums[i];
                    count = 1;
                }
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}