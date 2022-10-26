package leetcode.editor.cn;

/**
 * 青蛙过河
 *
 * @author why
 * @date 2022-10-25 17:00:25
 */
public class P403_FrogJump {
    public static void main(String[] args) {
        Solution solution = new P403_FrogJump().new Solution();
        solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canCross(int[] stones) {
            int n = stones.length;
            boolean[][] gap = new boolean[n + 1][n + 1];
            if (stones[1] != 1) return false;
            gap[1][1] = true;
            for (int i = 2; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int k = stones[i] - stones[j];
                    if (k<=j+1){
                        gap[i][k] = gap[j][k - 1] || gap[j][k] || gap[j][k + 1];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (gap[n - 1][i]) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}