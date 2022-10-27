package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * 有效的括号
 *
 * @author why
 * @date 2022-10-26 17:08:43
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) return false;
            ArrayDeque<Character> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char cur = s.charAt(i);
                if (cur == '(' || cur == '[' || cur == '{') {
                    q.addLast(cur);
                } else if (q.isEmpty()) {
                    return false;
                } else if (cur == ')' && q.peekLast() == '(') {
                    q.pollLast();
                } else if (cur == ']' && q.peekLast() == '[') {
                    q.pollLast();
                } else if (cur == '}' && q.peekLast() == '{') {
                    q.pollLast();
                } else {
                    return false;
                }
            }
            return q.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}