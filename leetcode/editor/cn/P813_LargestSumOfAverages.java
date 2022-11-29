package leetcode.editor.cn;

/**
 * 最大平均值和的分组
 *
 * @author why
 * @date 2022-11-28 17:18:12
 */
public class P813_LargestSumOfAverages {
    public static void main(String[] args) {
        Solution solution = new P813_LargestSumOfAverages().new Solution();
        solution.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestSumOfAverages(int[] nums, int m) {
            int n = nums.length;
            //设当前位置为i，则sum[i]是0到i所有元素的和
            double[] sum = new double[n + 10];
            for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
            double[][] f = new double[n + 10][m + 10];

            for (int i = 1; i <= n; i++) {
                //前i项分为j段，j<i且j<m
                for (int j = 1; j <= Math.min(i, m); j++) {
                    //j==1为平均数
                    if (j == 1) {
                        f[i][1] = sum[i] / i;
                    } else {
                        for (int k = 2; k <= i; k++) {
                            //以k为起点，得到k-1的最佳分段后的结果 + k到i这一段的平均值，枚举k，得到最优解
                            f[i][j] = Math.max(f[i][j], f[k - 1][j - 1] + (sum[i] - sum[k - 1]) / (i - k + 1));
                        }
                    }
                }
            }
            return f[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}