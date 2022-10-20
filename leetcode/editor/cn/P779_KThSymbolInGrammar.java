package leetcode.editor.cn;

import javax.naming.InitialContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 第K个语法符号
 *
 * @author why
 * @date 2022-10-20 17:03:41
 */
public class P779_KThSymbolInGrammar {
    public static void main(String[] args) {
        Solution solution = new P779_KThSymbolInGrammar().new Solution();
        solution.kthGrammar(30, 2352);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            }
            int i = 1 << (n - 2);
            if (k <= i) {
                return kthGrammar(n - 1, k);
            }
            return kthGrammar(n - 1, k - i) ^ 1;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}