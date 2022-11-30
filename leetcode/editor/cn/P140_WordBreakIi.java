package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分 II
 *
 * @author why
 * @date 2022-11-30 16:16:01
 */
public class P140_WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new P140_WordBreakIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String str, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            for (String word : wordDict) set.add(word);
            int n = str.length(), mask = 1 << (n - 1);
            List<String> ans = new ArrayList<>();
            for (int s = 0; s < mask; s++) {
                StringBuilder sb = new StringBuilder();
                boolean ok = true;
                for (int i = 0, j = -1; i < n && ok; i++) {
                    sb.append(str.charAt(i));
                    if (((s >> i) & 1) == 1 || i == n - 1) {
                        if (!set.contains(sb.substring(j + 1, sb.length()))) ok = false;
                        if (i != n - 1) sb.append(" ");
                        j = sb.length() - 1;
                    }
                }
                if (ok) ans.add(sb.toString());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}