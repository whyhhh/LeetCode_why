package leetcode.editor.cn;

/**
 * 全局倒置与局部倒置
 *
 * @author why
 * @date 2022-11-16 09:28:34
 */
public class P775_GlobalAndLocalInversions {
    public static void main(String[] args) {
        Solution solution = new P775_GlobalAndLocalInversions().new Solution();
        solution.isIdealPermutation(new int[]{0,2,1,3,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i] - i) >= 2) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}