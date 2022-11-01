package leetcode.editor.cn;

/**
 * 检查两个字符串数组是否相等
 *
 * @author why
 * @date 2022-11-01 11:03:32
 */
public class P1662_CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        Solution solution = new P1662_CheckIfTwoStringArraysAreEquivalent().new Solution();
        solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int n = word1.length;
            if (!check(word1, word2)) return false;
            int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
            while (i1 < n) {
                if (word1[i1].charAt(i2) == word2[j1].charAt(j2)) {
                    if (i2 < word1[i1].length() - 1) {
                        i2++;
                    } else {
                        i1++;
                        i2 = 0;
                    }
                    if (j2 < word2[j1].length() - 1) {
                        j2++;
                    } else {
                        j1++;
                        j2 = 0;
                    }
                } else {
                    return false;
                }
            }

            return true;
        }

        private boolean check(String[] word1, String[] word2) {
            int len1 = 0, len2 = 0;
            for (String s : word1) {
                len1 += s.length();
            }
            for (String s : word2) {
                len2 += s.length();
            }
            return len1 == len2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}