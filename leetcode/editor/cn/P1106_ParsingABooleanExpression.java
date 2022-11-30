package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 解析布尔表达式
 *
 * @author why
 * @date 2022-11-30 16:24:56
 */
public class P1106_ParsingABooleanExpression {
    public static void main(String[] args) {
        Solution solution = new P1106_ParsingABooleanExpression().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean parseBoolExpr(String s) {
            Deque<Character> nums = new ArrayDeque<>(), ops = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == ',') continue;
                if (c == 't' || c == 'f') nums.addLast(c);
                if (c == '|' || c == '&' || c == '!') ops.addLast(c);
                if (c == '(') nums.addLast('-');
                if (c == ')') {
                    char op = ops.pollLast(), cur = ' ';
                    while (!nums.isEmpty() && nums.peekLast() != '-') {
                        char top = nums.pollLast();
                        cur = cur == ' ' ? top : calc(top, cur, op);
                    }
                    if (op == '!') cur = cur == 't' ? 'f' : 't';
                    nums.pollLast();
                    nums.addLast(cur);
                }
            }
            return nums.peekLast() == 't';
        }

        char calc(char a, char b, char op) {
            boolean x = a == 't', y = b == 't';
            boolean ans = op == '|' ? x | y : x & y;
            return ans ? 't' : 'f';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}