package leetcode.editor.cn;

/**
 * 自定义字符串排序
 *
 * @author why
 * @date 2022-11-24 16:18:53
 */
public class P791_CustomSortString {
    public static void main(String[] args) {
        Solution solution = new P791_CustomSortString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String order, String s) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) cnt[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (char c : order.toCharArray()) {
                while (cnt[c - 'a']-- > 0) sb.append(c);
            }
            for (int i = 0; i < 26; i++) {
                while (cnt[i]-- > 0) sb.append((char) (i + 'a'));
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}