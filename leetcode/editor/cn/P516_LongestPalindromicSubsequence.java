package leetcode.editor.cn;

/**
 * 最长回文子序列
 *
 * @author why
 * @date 2022-11-15 22:24:40
 */
public class P516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new P516_LongestPalindromicSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int[][] f = new int[n][n];

            //查看以l为起点，len为长度的字符串钟，最大的回文串长度
            for (int len = 1; len <= n; len++) {

                //左边界从l开始，起始点+长度<总长度
                for (int l = 0; l + len - 1 < n; l++) {
                    //计算得到右边界位置
                    int r = l + len - 1;

                    if (len == 1) {
                        //当长度为1时，必然是回文串
                        f[l][r] = 1;
                    } else if (len == 2) {
                        //当长为2时，看两个字符是否相等，相等则存在的最长回文串长度为2，不想等则最床回文串长度为1
                        f[l][r] = cs[l] == cs[r] ? 2 : 1;
                    } else {
                        //len-1长度连续子串钟，取最大的回文串长度
                        f[l][r] = Math.max(f[l + 1][r], f[l][r - 1]);

                        //以len-2长度，不已l，r为边界的最大回文串长度，如果l，r处字符串相等，则该长度+2
                        f[l][r] = Math.max(f[l][r], f[l + 1][r - 1] + (cs[l] == cs[r] ? 2 : 0));
                    }
                }
            }

            return f[0][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}