package leetcode.editor.cn;

/**
 * 移动所有球到每个盒子所需的最小操作数
 *
 * @author why
 * @date 2022-12-02 17:06:55
 */
public class P1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        Solution solution = new P1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox().new Solution();
        solution.minOperations("110");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minOperations(String boxes) {
            char[] cs = boxes.toCharArray();
            int n = cs.length;
            int cur = 0, num = 0;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = cur;
                cur += cs[i] == '1' ? ++num : num;
            }
            cur = 0;
            num = 0;
            for (int i = n - 1; i >= 0; i--) {
                ans[i] += cur;
                cur += cs[i] == '1' ? ++num : num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}