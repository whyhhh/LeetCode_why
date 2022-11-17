package leetcode.editor.cn;

/**
 * 解码方法
 *
 * @author why
 * @date 2022-11-17 16:04:48
 */
public class P91_DecodeWays {
    public static void main(String[] args) {
        Solution solution = new P91_DecodeWays().new Solution();
        solution.numDecodings("226");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            char[] cs = s.toCharArray();
            if (cs[0] == '0') return 0;
            int n = cs.length;
            int[] dp = new int[n];
            dp[n - 1] = cs[n - 1] == '0' ? 0 : 1;

            for (int i = n - 2; i >= 0; i--) {
                if (cs[i + 1] == '0') {
                    if (cs[i] == '0' || cs[i] > '2') return 0;
                }
                if (cs[i] == '0') continue;
                if (((cs[i] - '0') * 10 + (cs[i + 1]) - '0') <= 26) {
                    if (i < n - 2) dp[i] = dp[i + 1] + dp[i + 2];
                    else dp[i] = dp[i + 1] + 1;
                } else {
                    dp[i] = dp[i + 1];
                }
            }
            return dp[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}