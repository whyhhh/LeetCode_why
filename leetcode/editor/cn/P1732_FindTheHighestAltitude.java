package leetcode.editor.cn;

/**
 * 找到最高海拔
 *
 * @author why
 * @date 2022-11-19 22:29:33
 */
public class P1732_FindTheHighestAltitude {
    public static void main(String[] args) {
        Solution solution = new P1732_FindTheHighestAltitude().new Solution();
        solution.largestAltitude(new int[]{52, -91, 72});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestAltitude(int[] gain) {
            int max = Math.max(0,gain[0]);
            for (int i = 1; i < gain.length; i++) {
                gain[i] += gain[i - 1];
                max = Math.max(max, gain[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}