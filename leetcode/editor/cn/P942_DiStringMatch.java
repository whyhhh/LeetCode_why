package leetcode.editor.cn;

/**
 * 增减字符串匹配
 *
 * @author why
 * @date 2022-12-10 23:32:33
 */
public class P942_DiStringMatch {
    public static void main(String[] args) {
        Solution solution = new P942_DiStringMatch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] diStringMatch(String s) {
            int n = s.length(), l = 0, r = n, idx = 0;
            int[] ans = new int[n + 1];
            for (int i = 0; i < n; i++) {
                ans[idx++] = s.charAt(i) == 'I' ? l++ : r--;
            }
            ans[idx] = l;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}