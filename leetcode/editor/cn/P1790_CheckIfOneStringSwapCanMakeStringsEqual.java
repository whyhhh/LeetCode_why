package leetcode.editor.cn;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author why
 * @date 2022-10-11 09:29:38
 */
public class P1790_CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new P1790_CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        solution.areAlmostEqual("bank", "kanb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int n = s1.length(), a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    if (a == 0) {
                        a = c1;
                        b = c2;
                    } else if (a > 0) {
                        if (a != c2 || b != c1) {
                            return false;
                        } else {
                            a = -1;
                            b = -1;
                        }
                    } else {
                        return false;
                    }
                }
            }
            return a <= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}