package leetcode.editor.cn;

import java.util.List;

/**
 * 删除字符串两端相同字符后的最短长度
 *
 * @author why
 * @date 2022-12-29 16:22:57
 */
public class P1750_MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        Solution solution = new P1750_MinimumLengthOfStringAfterDeletingSimilarEnds().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLength(String s) {
            int n = s.length(), l = 0, r = n - 1;
            char[] cs = s.toCharArray();
            while (l < r && cs[l] == cs[r]) {
                char c = cs[l];
                while (l <= r && cs[l] == c) l++;
                while (l <= r && cs[r] == c) r--;
            }
            return r - l + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}