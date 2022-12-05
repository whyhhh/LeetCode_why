package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 串联所有单词的子串
 *
 * @author why
 * @date 2022-12-05 17:31:05
 */
public class P30_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new P30_SubstringWithConcatenationOfAllWords().new Solution();
        solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> wordList = new ArrayList<>();

        public List<Integer> findSubstring(String s, String[] words) {
            int n = s.length(), m = words[0].length(), l = m * words.length;
            List<Integer> ans = new ArrayList<>();
            if (l > n) return ans;
            wordList.addAll(Arrays.asList(words));
            for (int i = l; i <= n; i++) {
                if (check(s.substring(i - l, i), m)) ans.add(i - l);
            }
            return ans;
        }

        boolean check(String s, Integer m) {
            List<String> list = new ArrayList<>(wordList);
            for (int i = 0; i < s.length(); i += m) {
                String cur = s.substring(i, i + m);
                if (!list.remove(cur)) return false;
            }
            System.out.println(s);
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}