package leetcode.editor.cn;

/**
 * 斐波那契数
 *
 * @author why
 * @date 2022-10-13 14:51:35
 */
public class P509_FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new P509_FibonacciNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] cache = new int[31];
        static {
            cache[0] = 0;
            cache[1] = 1;
            int  cur = 0,f1 = 0, f2 = 1;
            for (int i = 2; i < 31; i++) {
                cache[i] = cache[i-1]+cache[i-2];
            }
        }
        public int fib(int n) {
            return cache[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
