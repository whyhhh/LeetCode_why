package leetcode.editor.cn;

import javax.net.ssl.SSLContext;
import java.util.HashSet;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author why
 * @date 2022-12-05 17:14:54
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            HashSet<Character> set = new HashSet<>();
            char[] cs = s.toCharArray();
            int ans = 0;
            for (int l = 0, r = 0; r < n; r++) {
                while (set.contains(cs[r])) set.remove(cs[l++]);
                set.add(cs[r]);
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}