package leetcode.editor.cn;

/**
 * K 个不同整数的子数组
 *
 * @author why
 * @date 2022-12-03 22:43:51
 */
public class P992_SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Solution solution = new P992_SubarraysWithKDifferentIntegers().new Solution();
        solution.subarraysWithKDistinct(new int[]{1, 2, 1,1, 2, 3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            int n = nums.length;
            int[] lower = new int[n], upper = new int[n];
            //每个点为终点，找到最远的满足有k个不同数字的区间的左下标
            find(lower, nums, k);
            //每个点为起点，最远的满足可以获得k-1个不同字符的点
            find(upper, nums, k - 1);
            int ans = 0;
            for (int i = 0; i < n; i++) ans += upper[i] - lower[i];
            return ans;
        }

        void find(int[] arr, int[] nums, int k) {
            int n = nums.length;
            int[] cnt = new int[n + 1];
            //sum：不同数字个数
            for (int i = 0, j = 0, sum = 0; i < n; i++) {
                //当前点为左边界
                int right = nums[i];
                ///当前的数值还未出现，sum++
                if (cnt[right] == 0) sum++;
                cnt[right]++;

                //当出现的不同数字总数>k,找到满足sum==k最近
                while (sum > k) {
                    int left = nums[j++];
                    cnt[left]--;
                    if (cnt[left] == 0) sum--;
                }
                arr[i] = j;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}