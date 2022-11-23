package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长数对链
 *
 * @author why
 * @date 2022-11-23 10:30:00
 */
public class P646_MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new P646_MaximumLengthOfPairChain().new Solution();
        solution.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 5}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            int ans = 0;
            int n = pairs.length;
            int[] f = new int[n];
            Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            for (int i = 0; i < n; i++) {
                f[i] = 1;
                for (int j = i - 1; j >= 0 && f[i] == 1; j--) {
                    if (pairs[j][1] < pairs[i][0]) f[i] = f[j] + 1;
                }
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}