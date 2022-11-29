package leetcode.editor.cn;

/**
 * 统计一致字符串的数目
 *
 * @author why
 * @date 2022-11-29 17:56:51
 */
public class P1684_CountTheNumberOfConsistentStrings {
    public static void main(String[] args) {
        Solution solution = new P1684_CountTheNumberOfConsistentStrings().new Solution();
        solution.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int[] f = new int[26];
            int n = allowed.length();
            for (int i = 0; i < n; i++) {
                f[allowed.charAt(i) - 'a'] = 1;
            }

            int ans = 0;
            for (String word : words) {
                int m = word.length();
                boolean ok = true;
                for (int i = 0; i < m && ok; i++) {
                    if (f[word.charAt(i) - 'a'] == 0) ok = false;
                }
                if (ok) ans++;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}