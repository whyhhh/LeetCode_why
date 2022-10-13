package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 括号的分数
 *
 * @author why
 * @date 2022-10-10 16:53:50
 */
public class P856_ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new P856_ScoreOfParentheses().new Solution();
        solution.scoreOfParentheses("((()())())");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int scoreOfParentheses(String s) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    list.addLast(0);
                } else {
                    Integer cur = list.removeLast();
                    list.addLast(list.removeLast() + Math.max(cur * 2, 1));
                }
            }
            return list.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
