package leetcode.editor.cn;

/**
 * 盒子中小球的最大数量
 *
 * @author why
 * @date 2022-11-23 10:14:39
 */
public class P1742_MaximumNumberOfBallsInABox {
    public static void main(String[] args) {
        Solution solution = new P1742_MaximumNumberOfBallsInABox().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            int[] f = new int[50];
            int ans = 0;
            for (int i = lowLimit; i <= highLimit; i++) {
                ans = Math.max(++f[getBox(i)], ans);
            }
            return ans;
        }

        private int getBox(int i) {
            int ans = 0;
            while (i != 0) {
                i /= 10;
                ans += i % 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}