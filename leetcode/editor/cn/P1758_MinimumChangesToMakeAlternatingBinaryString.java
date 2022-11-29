package leetcode.editor.cn;

/**
 * 生成交替二进制字符串的最少操作数
 *
 * @author why
 * @date 2022-11-29 11:54:24
 */
public class P1758_MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        Solution solution = new P1758_MinimumChangesToMakeAlternatingBinaryString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(String s) {
            int n = s.length();
            int ans = 0;
            char[] cs = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (cs[i] == '0') ans++;
                } else {
                    if (cs[i] == '1') ans++;
                }
            }
            return Math.min(ans, n - ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}