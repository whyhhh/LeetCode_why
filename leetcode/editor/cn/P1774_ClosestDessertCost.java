package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最接近目标价格的甜点成本
 *
 * @author why
 * @date 2022-12-04 18:39:46
 */
public class P1774_ClosestDessertCost {
    public static void main(String[] args) {
        Solution solution = new P1774_ClosestDessertCost().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0x3f3f3f3f;

        public int closestCost(int[] base, int[] top, int target) {
            for (int x : base) dfs(0, x, target, top);
            return ans;
        }
        void dfs(int x, int sum, int target, int[] top) {
            // a：当前这种选择最接近的价格，b：所有选择最接近的价格
            int a = Math.abs(target - sum), b = Math.abs(target - ans);
            if (a < b) ans = sum;
            if (a == b && sum < ans) ans = sum;
            if (sum > target) return;
            for (int i = x; i < top.length; i++) {
                //当前配料选一种
                dfs(i + 1, sum + top[i], target, top);
                //当前配料选两种
                dfs(i + 1, sum + 2 * top[i], target, top);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}