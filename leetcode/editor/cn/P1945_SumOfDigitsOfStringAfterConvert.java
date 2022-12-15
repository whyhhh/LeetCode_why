package leetcode.editor.cn;

/**
 * 字符串转化后的各位数字之和
 *
 * @author why
 * @date 2022-12-15 15:44:29
 */
public class P1945_SumOfDigitsOfStringAfterConvert {
    public static void main(String[] args) {
        Solution solution = new P1945_SumOfDigitsOfStringAfterConvert().new Solution();
        solution.getLucky("leetcode", 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getLucky(String s, int k) {
            int n = s.length();
            int ans = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(s.charAt(i) - 'a' + 1);
            }
            String str = sb.toString();
            for (int i = 0; i < k; i++) {
                ans = 0;
                int m = str.length();
                for (int j = 0; j < m; j++) {
                    ans += str.charAt(j) - '0';
                }
                str = String.valueOf(ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}