package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 至少在两个数组中出现的值
 *
 * @author why
 * @date 2022-12-29 15:57:35
 */
public class P2032_TwoOutOfThree {
    public static void main(String[] args) {
        Solution solution = new P2032_TwoOutOfThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            Set<Integer> set3 = new HashSet<>();
            List<Integer> ans = new ArrayList<>();
            for (int num : nums1) set1.add(num);
            for (int num : nums2) set2.add(num);
            for (int num : nums3) set3.add(num);

            for (Integer num : set1) map.put(num, 1);
            for (Integer num : set2) map.put(num, map.getOrDefault(num, 0) + 1);
            for (Integer num : set3) map.put(num, map.getOrDefault(num, 0) + 1);

            map.forEach((k, v) -> {
                if (v > 1) ans.add(k);
            });

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}