package leetcode.editor.cn;

/**
 * 斐波那契数
 * @author why
 * @date 2022-10-13 14:51:35
 */
public class P509_FibonacciNumber{
    public static void main(String[] args) {
        Solution solution = new P509_FibonacciNumber().new Solution();
        
    }
	 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int ans = 0;
        int f1 = 0, f2 = 1;
        for (int i = 1; i < n; i++) {
            ans = f1 + f2;
            f1 = f2;
            f2 = ans;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
