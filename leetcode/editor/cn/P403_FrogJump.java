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
        solution.canCross(new int[]{0,1,3,5,6,8,12,17});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canCross(int[] stones) {
            int n = stones.length;
            //第一次跳
            if (stones[1] != 1) return false;

            boolean[][] f = new boolean[n + 1][n + 1];
            f[1][1] = true;
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    //从j跳到i需要跳k
                    int k = stones[i] - stones[j];
                    // 而从位置 j 发起的跳跃最多不超过 j + 1
                    if (k <= j + 1) {
                        // 当j上一步跳了k-1或k或k+1个单位时，j可以以k的距离跳到i
                        f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                if (f[n - 1][i]) return true;
            }
            return false;
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}