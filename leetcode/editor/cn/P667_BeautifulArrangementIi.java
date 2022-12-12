package leetcode.editor.cn;

/**
 * 优美的排列 II
 *
 * @author why
 * @date 2022-12-12 09:51:04
 */
public class P667_BeautifulArrangementIi {
    public static void main(String[] args) {
        Solution solution = new P667_BeautifulArrangementIi().new Solution();
        solution.constructArray(5, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] ans = new int[n];
            int t = n - k - 1;
            //自然数序列
            for (int i = 0; i < t; i++) ans[i] = i + 1;
            //按照，i,n.i+1,n-1放入数字
            for (int i = t, a = n - k, b = n; i < n; ) {
                ans[i++] = a++;
                if (i < n) ans[i++] = b--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}