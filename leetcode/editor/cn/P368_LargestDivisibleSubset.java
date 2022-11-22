package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最大整除子集
 *
 * @author why
 * @date 2022-11-22 16:31:50
 */
public class P368_LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new P368_LargestDivisibleSubset().new Solution();
        solution.largestDivisibleSubset(new int[]{1, 2, 3, 4, 5, 6, 8, 16, 18, 100});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int[][] f = new int[n][2];

            for (int i = 0; i < n; i++) {
                // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
                int len = 1, prev = i;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                        if (f[j][0] + 1 > len) {
                            len = f[j][0] + 1;
                            prev = j;
                        }
                    }
                }
                // 记录「最终长度」&「从何转移而来」
                f[i][0] = len;
                f[i][1] = prev;
                System.out.println(1);
            }

            // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
            int max = -1, idx = -1;
            for (int i = 0; i < n; i++) {
                if (f[i][0] > max) {
                    idx = i;
                    max = f[i][0];
                }
            }

            // 使用 g[] 数组回溯出具体方案
            List<Integer> ans = new ArrayList<>();
            while (ans.size() != max) {
                ans.add(nums[idx]);
                idx = f[idx][1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}