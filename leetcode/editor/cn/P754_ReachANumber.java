package leetcode.editor.cn;

/**
 * 到达终点数字
 *
 * @author why
 * @date 2022-11-30 15:36:15
 */
public class P754_ReachANumber {
    public static void main(String[] args) {
        Solution solution = new P754_ReachANumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reachNumber(int target) {
            int result = 0, num = 0, t = Math.abs(target);

            // 直到num值大于等于t，并且num减t是偶数，才结束while循环
            while (num < t || (num - t) % 2 != 0)
                num += ++result; // num=1+2+3+4+……
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}