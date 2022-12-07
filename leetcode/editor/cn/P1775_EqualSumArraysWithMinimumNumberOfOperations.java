package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 通过最少操作次数使数组的和相等
 *
 * @author why
 * @date 2022-12-07 22:50:58
 */
public class P1775_EqualSumArraysWithMinimumNumberOfOperations {
    public static void main(String[] args) {
        Solution solution = new P1775_EqualSumArraysWithMinimumNumberOfOperations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length)
                return -1;

            int d = Arrays.stream(nums2).sum() - Arrays.stream(nums1).sum();

            // 交换，统一让 nums1 的数变大，nums2 的数变小
            if (d < 0) {
                d = -d;
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }

            int[] cnt = new int[6]; // 统计每个数的最大变化量
            for (int x : nums1) ++cnt[6 - x]; // nums1 的变成 6
            for (int x : nums2) ++cnt[x - 1]; // nums2 的变成 1

            // 从大到小枚举最大变化量 5 4 3 2 1
            for (int i = 5, ans = 0; ; --i) {
                // 可以让 d 变为 0
                if (i * cnt[i] >= d) return ans + (d + i - 1) / i;

                ans += cnt[i]; // 需要所有最大变化量为 i 的数
                d -= i * cnt[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}