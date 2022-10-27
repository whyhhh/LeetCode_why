package leetcode.editor.cn;

/**
 * 最长回文子串
 *
 * @author why
 * @date 2022-10-27 15:59:23
 */
public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("aacabdkacaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String ans = s.substring(0, 1);
            int len = 0;
            int n = s.length();
            int l, r;
            char[] chars = s.toCharArray();
            for (int i = 1; i < n; i++) {
                if (chars[i - 1] == chars[i]) {
                    l = i - 1;
                    r = i;
                    while (l >= 0 && r < n && chars[l] == chars[r]) {
                        l--;r++;
                    }
                    l++;r--;
                    if (len < r - l + 1) {
                        ans = s.substring(l, r + 1);
                        len = r - l + 1;
                    }
                }

                if (i + 1 < n && chars[i - 1] == chars[i + 1]) {
                    l = i - 1;
                    r = i + 1;
                    while (l >= 0 && r < n && chars[l] == chars[r]) {
                        l--;r++;
                    }
                    l++;r--;
                    if (len < r - l + 1) {
                        ans = s.substring(l, r + 1);
                        len = r - l + 1;
                    }
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}