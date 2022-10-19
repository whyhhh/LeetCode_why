package leetcode.editor.cn;

/**
 * 不同的子序列 II
 *
 * @author why
 * @date 2022-10-18 17:02:44
 */
public class P940_DistinctSubsequencesIi {
    public static void main(String[] args) {
        Solution solution = new P940_DistinctSubsequencesIi().new Solution();
        solution.distinctSubseqII("abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distinctSubseqII(String s) {
            int mod = (int) 1e9 + 7;
            int n = s.length();

            //包含第i位字母的组合个数
            int[] count = new int[26];
            int ans = 0;
            int other = 0;

            for (int i = 0; i < n; i++) {
                int cur = s.charAt(i) - 'a';

                other = ans - count[cur];
                count[cur] = ans + 1;
                ans = ((other + count[cur])%mod+mod)%mod;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}