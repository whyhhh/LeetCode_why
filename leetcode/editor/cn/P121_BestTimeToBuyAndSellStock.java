package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机
 *
 * @author why
 * @date 2022-10-10 16:40:15
 */
public class P121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121_BestTimeToBuyAndSellStock().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int ans = 0;
            int buy = prices[0];
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, prices[i] - buy);
                buy = Math.min(buy, prices[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
