package leetcode.editor.cn;

import jdk.nashorn.internal.ir.WhileNode;

/**
 * 整数替换
 *
 * @author why
 * @date 2022-10-08 16:10:46
 */
public class P397_IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new P397_IntegerReplacement().new Solution();
        solution.integerReplacement(100000000);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerReplacement(int n) {
            long num = n;
            int ans = 0;
            while (num > 1) {
                if (num % 2 == 0) {
                    num = num >> 1;
                } else {
                    if (num == 3 || (num >> 1) % 2 == 0) {
                        num--;
                    } else {
                        num++;
                    }
                }
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
