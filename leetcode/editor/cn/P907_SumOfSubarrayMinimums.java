package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 子数组的最小值之和
 *
 * @author why
 * @date 2022-10-28 09:40:57
 */
public class P907_SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Solution solution = new P907_SumOfSubarrayMinimums().new Solution();
        solution.sumSubarrayMins(new int[]{3, 1, 2, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) 1e9 + 7;

        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            int[] l = new int[n];
            int[] r = new int[n];
            Arrays.fill(l, -1);
            Arrays.fill(r, n);
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) r[q.pollLast()] = i;
                q.addLast(i);
            }
            q.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!q.isEmpty() && arr[q.peekLast()] > arr[i]) l[q.pollLast()] = i;
                q.addLast(i);
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                int a = i - l[i], b = r[i] - i;
                ans += a * 1L * b % MOD * arr[i] % MOD;
                ans %= MOD;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}