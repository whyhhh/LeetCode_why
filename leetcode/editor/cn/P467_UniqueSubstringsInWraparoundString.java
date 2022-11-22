package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 环绕字符串中唯一的子字符串
 *
 * @author why
 * @date 2022-11-22 13:54:08
 */
public class P467_UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        Solution solution = new P467_UniqueSubstringsInWraparoundString().new Solution();
        solution.findSubstringInWraproundString("abaab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSubstringInWraproundString(String p) {
            int n = p.length();
            int[] f = new int[26];
            char[] cp = p.toCharArray();
            int ans = 0;
            f[cp[0] - 'a']++;

            for (int i = 1, j = 1; i < n; i++) {
                if (cp[i - 1] + 1 == cp[i] || (cp[i - 1] == 'z' && cp[i] == 'a')) {
                    j++;
                } else {
                    j = 1;
                }
                f[cp[i]-'a'] =  Math.max(j,f[cp[i]-'a'] );

            }
            for (int i = 0; i < 26; i++) ans += f[i];
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}