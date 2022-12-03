package leetcode.editor.cn;

/**
 * 字符串中第二大的数字
 *
 * @author why
 * @date 2022-12-03 22:31:39
 */
public class P1796_SecondLargestDigitInAString {
    public static void main(String[] args) {
        Solution solution = new P1796_SecondLargestDigitInAString().new Solution();
        solution.secondHighest("1a0");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int secondHighest(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length;
            int a = -1, b = -1;
            for (int i = 0, cur; i < n; i++) {
                cur = cs[i] - '0';
                if (cur >= 0 && cur <= 9) {
                    if (a == -1) {
                        a = cur;
                    } else if (cur > a) {
                        if (b == -1) {
                            b = cur;
                        } else if (cur > b) {
                            a = b;
                            b = cur;
                        } else if (cur < b) {
                            a = cur;
                        }
                    } else if (cur < a) {
                        if (b == -1) {
                            b = a;
                            a = cur;
                        }
                    }
                }
            }
            return b == -1 ? -1 : a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}