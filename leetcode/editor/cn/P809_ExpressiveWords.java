package leetcode.editor.cn;

/**
 * 情感丰富的文字
 *
 * @author why
 * @date 2022-11-25 09:18:08
 */
public class P809_ExpressiveWords {
    public static void main(String[] args) {
        Solution solution = new P809_ExpressiveWords().new Solution();
        solution.expressiveWords("abcd", new String[]{"abc"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int expressiveWords(String s, String[] words) {
            int ans = 0;
            for (String word : words) {
                if (check(s, word)) ans++;
            }
            return ans;
        }

        private boolean check(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n < m) return false;
            int i = 0, j = 0;
            int len1 = 1, len2 = 1;
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            while (i < n && j < m) {
                while (i < n - 1 && c1[i] == c1[i + 1]) {
                    len1++;
                    i++;
                }
                while (j < m - 1 && c2[j] == c2[j + 1]) {
                    len2++;
                    j++;
                }
                if (c1[i] != c2[j]) return false;
                if (len1 < len2 || (len1 == 2 && len2 == 1)) return false;

                i++;
                j++;
                len1 = 1;
                len2 = 1;
            }
            return i==n&&j==m;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}