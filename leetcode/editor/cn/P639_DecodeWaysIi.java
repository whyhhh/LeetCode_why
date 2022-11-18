package leetcode.editor.cn;

import javax.swing.text.html.CSS;

/**
 * 解码方法 II
 *
 * @author why
 * @date 2022-11-17 17:13:47
 */
public class P639_DecodeWaysIi {
    public static void main(String[] args) {
        Solution solution = new P639_DecodeWaysIi().new Solution();
        solution.numDecodings("*123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) 1e9 + 7;

        public int numDecodings(String s) {
            int n = s.length();
            long[] dp = new long[3];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                char cur = s.charAt(i);
                //当前位置数字
                long cnt = 0;
                //dp[p1]:不考虑第i位字符情况下个数，dp[p2]:不考虑i-1位字符情况下个数
                int p1 = i % 3, p2 = (i - 1) % 3;

                // 枚举组成什么 item（A -> 1; B -> 2 ...）
                for (int item = 1; item <= 26; item++) {
                    // 该 item 由一个字符组成
                    if (item < 10) {
                        //当前位置的的字符可以单独代表一个字母(1-9或者*)
                        if (cur == '*' || cur == item + '0') cnt += dp[p1];
                    } else {
                        // 该 item 由两个字符组成
                        if (i - 1 < 0) break;
                        //获得获得前一位数字
                        char prev = s.charAt(i - 1);
                        //a:第一位，b:第二位
                        int a = item / 10 + '0', b = item % 10 + '0';
                        //（前一位为*或者1或者2）&&（后一位数字满足||后一位不是数字，且数字要求不为0）
                        if ((prev == '*' || prev == a) && (cur == b || (cur == '*' && b != '0'))) cnt += dp[p2];
                    }
                }
                //不考虑第i+1位字符情况下组成个数
                dp[(i + 1) % 3] = cnt % mod;
            }
            return (int) (dp[n % 3]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}