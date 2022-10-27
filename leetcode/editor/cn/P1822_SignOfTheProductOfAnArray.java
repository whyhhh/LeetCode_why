package leetcode.editor.cn;

/**
 * 数组元素积的符号
 *
 * @author why
 * @date 2022-10-27 14:21:19
 */
public class P1822_SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        Solution solution = new P1822_SignOfTheProductOfAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arraySign(int[] nums) {
            int ans = 1;
            for (int num : nums) {
                if (num == 0) return 0;
                if (num < 0) ans *= -1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}