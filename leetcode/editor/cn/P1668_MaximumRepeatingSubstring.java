package leetcode.editor.cn;

/**
 * 最大重复子字符串
 *
 * @author why
 * @date 2022-11-03 22:50:00
 */
public class P1668_MaximumRepeatingSubstring {
    public static void main(String[] args) {
        Solution solution = new P1668_MaximumRepeatingSubstring().new Solution();
        solution.maxRepeating("a", "a");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int n = sequence.length(), m = word.length(), ans = 0;
            int[] f = new int[n];
            for (int i = 0; i <= n - m; i++) {
                if (sequence.substring(i, i + m).equals(word)) {
                    f[i] = i - m >= 0 ? f[i - m] + 1 : 1;
                }
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}