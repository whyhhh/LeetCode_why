package leetcode.editor.cn;

/**
 * 分割数组
 *
 * @author why
 * @date 2022-10-24 17:47:37
 */
public class P915_PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        Solution solution = new P915_PartitionArrayIntoDisjointIntervals().new Solution();
        solution.partitionDisjoint(new int[]{5, 0, 3, 8, 6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length, l = 1, r = n;
            int lmax = nums[0], rmin;
            while (l <= r) {
                r = n;
                rmin = 1000001;
                while (l < r && lmax <= Math.min(rmin, nums[r - 1])) {
                    rmin = Math.min(rmin, nums[--r]);
                }
                while (l < r) {
                    lmax = Math.max(lmax, nums[l++]);
                }
                if (lmax <= rmin) {
                    return l;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}