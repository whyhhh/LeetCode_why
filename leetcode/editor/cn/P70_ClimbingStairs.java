package leetcode.editor.cn;

import com.sun.source.tree.NewArrayTree;

/**
 * 爬楼梯
 *
 * @author why
 * @date 2022-10-26 17:35:29
 */
public class P70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70_ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] init = new int[50];

        static {
            init[1] = 1;
            init[2] = 2;
            for (int i = 3; i <= 45; i++) {
                init[i] = init[i - 1] + init[i - 2];
            }
        }

        public int climbStairs(int n) {
            return init[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}