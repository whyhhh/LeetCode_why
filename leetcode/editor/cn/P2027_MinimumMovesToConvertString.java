package leetcode.editor.cn;

/**
 * 转换字符串的最少操作次数
 *
 * @author why
 * @date 2022-12-29 16:34:21
 */
public class P2027_MinimumMovesToConvertString {
    public static void main(String[] args) {
        Solution solution = new P2027_MinimumMovesToConvertString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumMoves(String s) {
            int n = s.length(), ans = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'O') continue;
                i += 2;
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}