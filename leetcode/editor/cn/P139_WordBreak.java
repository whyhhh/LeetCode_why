package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 * @author why
 * @date 2022-11-30 15:42:47
 */
public class P139_WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139_WordBreak().new Solution();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        solution.wordBreak("leetcode", list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            for (String word : wordDict) set.add(word);
            int n = s.length();
            boolean[] f = new boolean[n + 10];
            f[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i && !f[i]; j++) {
                    String sub = s.substring(j - 1, i);
                    if (set.contains(sub)) f[i] = f[j - 1];
                }
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}