package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中不同整数的数目
 *
 * @author why
 * @date 2022-12-06 22:28:42
 */
public class P1805_NumberOfDifferentIntegersInAString {
    public static void main(String[] args) {
        Solution solution = new P1805_NumberOfDifferentIntegersInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDifferentIntegers(String word) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) <= '9') {
                    int j = i;
                    while (j < word.length() && word.charAt(j) <= '9') j++;
                    while (i < j && word.charAt(i) == '0') i++;
                    set.add(word.substring(i, j));
                    i = j;
                }
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}