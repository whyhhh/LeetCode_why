package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.function.IntPredicate;

/**
 * 股票价格跨度
 *
 * @author why
 * @date 2022-10-21 17:08:34
 */
public class P901_OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new P901_OnlineStockSpan().new StockSpanner();
        stockSpanner.next(100);
        stockSpanner.next(80);
        stockSpanner.next(60);
        stockSpanner.next(70);
        stockSpanner.next(60);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        Deque<int[]> stack;

        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int ans = 0;
            while (!stack.isEmpty() && stack.peekLast()[0] <= price) {
                ans += stack.pollLast()[1];

            }
            stack.addLast(new int[]{price, ++ans});
            return ans;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}