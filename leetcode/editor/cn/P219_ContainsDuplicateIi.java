package leetcode.editor.cn;

import java.util.Set;
import java.util.TreeSet;

/**
 * 存在重复元素 II
 *
 * @author why
 * @date 2022-12-01 09:42:36
 */
public class P219_ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new P219_ContainsDuplicateIi().new Solution();
        solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if (i > k) set.remove(nums[i - k - 1]);
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}