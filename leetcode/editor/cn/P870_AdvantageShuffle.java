package leetcode.editor.cn;

import java.util.*;

/**
 * 优势洗牌
 *
 * @author why
 * @date 2022-10-11 10:38:45
 */
public class P870_AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new P870_AdvantageShuffle().new Solution();
        int[] nums1 = new int[]{2,0,4,1,2};
        int[] nums2 = new int[]{1,3,0,0,2};
        int[] nums3 = new int[]{2,7,11,15};
        int[] nums4 = new int[]{1,10,4,11};
        solution.advantageCount(nums1, nums2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] ans = new int[n];
            TreeSet<Integer> set = new TreeSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                set.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int i = 0; i < nums2.length; i++) {
                Integer ceiling = set.ceiling(nums2[i]+1);
                if (ceiling == null) {
                    ceiling = set.ceiling(-1);
                }
                ans[i] = ceiling;
                map.put(ceiling, map.get(ceiling) - 1);
                if (map.get(ceiling)== 0) {
                    set.remove(ceiling);
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
