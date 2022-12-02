package leetcode.editor.cn;

import javax.xml.transform.Source;

/**
 * 区域和检索 - 数组不可变
 *
 * @author why
 * @date 2022-12-02 17:31:02
 */
public class P303_RangeSumQueryImmutable {
    public static void main(String[] args) {
        NumArray solution = new P303_RangeSumQueryImmutable().new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        solution.sumRange(0, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}