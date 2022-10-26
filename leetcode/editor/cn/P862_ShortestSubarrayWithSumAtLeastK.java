package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 和至少为 K 的最短子数组
 *
 * @author why
 * @date 2022-10-26 09:41:10
 */
public class P862_ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        Solution solution = new P862_ShortestSubarrayWithSumAtLeastK().new Solution();
        int[] ints =new int[10000];
        Arrays.fill(ints, -1000000);
        solution.shortestSubarray(ints, 61);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length, ans = n + 1;
            long[] sums = new long[n + 1];
            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i = 0; i <= n; i++) {
                long cur = sums[i];
                while (!q.isEmpty() && cur - sums[q.peekFirst()] >= k) {
                    ans = Math.min(ans, i - q.pollFirst());
                }
                while (!q.isEmpty() && cur <= sums[q.peekLast()]) {
                    q.pollLast();
                }
                q.addLast(i);
            }
            return ans > n ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}