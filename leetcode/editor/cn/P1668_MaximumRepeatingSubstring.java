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
        solution.maxRepeating("ababc", "ab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int ans = 0;
            int n = sequence.length(), m = word.length();
            int[] t = new int[n + 10];
            for (int i = 1; i <= n; i++) {
                if (i - m < 0) continue;
                if (sequence.substring(i - m, i).equals(word)) t[i] = t[i - m] + 1;
                ans = Math.max(ans, t[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}