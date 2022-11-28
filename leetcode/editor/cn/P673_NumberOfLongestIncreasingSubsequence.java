package leetcode.editor.cn;

/**
 * 最长递增子序列的个数
 *
 * @author why
 * @date 2022-11-28 15:06:12
 */
public class P673_NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P673_NumberOfLongestIncreasingSubsequence().new Solution();
        solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n], g = new int[n];
            int max = 1;
            for (int i = 0; i < n; i++) {
                f[i] = g[i] = 1;
                for (int j = 0; j < i; j++) {
                    //前面数小于后面的数
                    if (nums[j] < nums[i]) {
                        //说明f还没有被更新，更新即可
                        if (f[i] < f[j] + 1) {
                            f[i] = f[j] + 1;
                            g[i] = g[j];
                            //说明f已经更新过了，需要再更新g
                        } else if (f[i] == f[j] + 1) {
                            g[i] += g[j];
                        }
                    }
                }
                max = Math.max(max, f[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (f[i] == max) ans += g[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}