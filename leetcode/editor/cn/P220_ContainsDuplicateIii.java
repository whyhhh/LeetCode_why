package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
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
        long size;

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            Map<Long, Long> map = new HashMap<>();
            size = t + 1L;
            for (int i = 0; i < n; i++) {
                long u = nums[i] * 1L;
                long idx = getIdx(u);
                // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
                if (map.containsKey(idx)) return true;
                // 检查相邻的桶
                long l = idx - 1, r = idx + 1;
                if (map.containsKey(l) && u - map.get(l) <= t) return true;
                if (map.containsKey(r) && map.get(r) - u <= t) return true;
                // 建立目标桶
                map.put(idx, u);
                // 移除下标范围不在 [max(0, i - k), i) 内的桶
                if (i >= k) map.remove(getIdx(nums[i - k] * 1L));
            }
            return false;
        }

        long getIdx(long u) {
            return u >= 0 ? u / size : ((u + 1) / size) - 1;
        }
        //滑动窗口+treeSet的运用
//        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//            int n = nums.length;
//            TreeSet<Integer> set = new TreeSet<>();
//            for (int i = 0; i < n; i++) {
//                if (i > k) set.remove(nums[i - k - 1]);
//                Integer floor = set.floor(nums[i]);
//                Integer ceiling = set.ceiling(nums[i]);
//                if (floor != null && nums[i] - floor <= t) return true;
//                if (ceiling != null && ceiling - nums[i] <= t) return true;
//                set.add(nums[i]);
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}