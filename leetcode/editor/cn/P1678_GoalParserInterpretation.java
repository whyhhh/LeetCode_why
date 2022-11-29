package leetcode.editor.cn;

/**
 * 设计 Goal 解析器
 *
 * @author why
 * @date 2022-11-29 17:46:01
 */
public class P1678_GoalParserInterpretation {
    public static void main(String[] args) {
        Solution solution = new P1678_GoalParserInterpretation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String interpret(String command) {
            StringBuilder sb = new StringBuilder();
            int n = command.length();
            for (int i = 0; i < n; i++) {
                if (command.startsWith("()", i)) {
                    sb.append("o");
                    i++;
                } else if (command.startsWith("(al)", i)) {
                    sb.append("al");
                    i += 3;
                } else {
                    sb.append(command.charAt(i));
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}