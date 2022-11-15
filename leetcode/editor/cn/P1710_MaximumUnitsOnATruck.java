package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 卡车上的最大单元数
 *
 * @author why
 * @date 2022-11-15 22:09:58
 */
public class P1710_MaximumUnitsOnATruck {
    public static void main(String[] args) {
        Solution solution = new P1710_MaximumUnitsOnATruck().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
            int n = boxTypes.length, ans = 0;
            for (int i = 0; i < n; i++) {
                if (truckSize <= boxTypes[i][0]) {
                    ans += (truckSize * boxTypes[i][1]);
                    break;
                }
                ans += (boxTypes[i][0] * boxTypes[i][1]);
                truckSize -= boxTypes[i][0];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}