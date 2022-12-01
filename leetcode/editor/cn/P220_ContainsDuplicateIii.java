package leetcode.editor.cn;

import java.util.Set;
import java.util.TreeSet;

/**
 * 存在重复元素 III
 *
 * @author why
 * @date 2022-12-01 09:50:22
 */
public class P220_ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new P220_ContainsDuplicateIii().new Solution();
        solution.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if (i > k) set.remove(nums[i - k - 1]);
                Integer floor = set.floor(nums[i]);
                Integer ceiling = set.ceiling(nums[i]);
                if (floor != null && nums[i] - floor <= t) return true;
                if (ceiling != null && ceiling - nums[i] <= t) return true;
                set.add(nums[i]);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}