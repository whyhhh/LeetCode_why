package leetcode.editor.cn;



/**
 * 最大为 N 的数字组合
 *
 * @author why
 * @date 2022-10-18 15:00:52
 */
public class P902_NumbersAtMostNGivenDigitSet {
    public static void main(String[] args) {
        Solution solution = new P902_NumbersAtMostNGivenDigitSet().new Solution();
        solution.atMostNGivenDigitSet(new String[]{"1", "2", "3", "5", "7"}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //digits数量
        int sum;
        //n长度
        int len;
        //数字num有sums[num]个小于等于num的数
        int sums[] = new int[10];
        //digits=1时，该数字存在
        int digits[] = new int[10];

        public int atMostNGivenDigitSet(String[] digits, int n) {
            int ans = 0;
            char[] nums = String.valueOf(n).toCharArray();
            len = nums.length;
            sum = digits.length;
            for (String digit : digits) {
                int num = Integer.parseInt(digit);
                this.digits[num] = 1;
                for (int i = num; i <= 9; i++) {
                    sums[i]++;
                }
            }

            //比n低一位时，什么数都可以
            for (int i = 1; i < len; i++) {
                ans += Math.pow(sum, i);
            }
            ans += dfs(nums, 0);
            return ans;
        }

        private int dfs(char[] nums, int i) {
            int ans;
            int num = nums[i] - '0';
            if (i == len - 1) {
                return sums[num];
            }
            if (digits[num] == 1) {
                ans = sums[num] - 1 > 0 ? (sums[num] - 1) * (int) Math.pow(sum, len - i - 1) : 0;
                return ans + dfs(nums, i + 1);
            } else {
                ans = sums[num] > 0 ? sums[num] * (int) Math.pow(sum, len - i - 1) : 0;
                return ans;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

