package leetcode.editor.cn;

/**
 * 第 N 个神奇数字
 *
 * @author why
 * @date 2022-11-22 09:39:26
 */
public class P878_NthMagicalNumber {
    public static void main(String[] args) {
        Solution solution = new P878_NthMagicalNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long MOD = (long) 1e9 + 7;

        public int nthMagicalNumber(int n, int a, int b) {
            long lcm = (long) a / gcd(a, b) * b;
            long left = 0, right = (long) Math.max(a, b) * n; // 开区间 (left, right)
            while (left + 1 < right) { // 开区间不为空
                long mid = left + (right - left) / 2;
                if (mid / a + mid / b - mid / lcm >= n)
                    right = mid; // 范围缩小到 (left, mid)
                else
                    left = mid; // 范围缩小到 (mid, right)
            }
            return (int) (right % MOD);
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}