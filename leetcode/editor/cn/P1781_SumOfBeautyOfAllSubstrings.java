package leetcode.editor.cn;

/**
 * 所有子字符串美丽值之和
 *
 * @author why
 * @date 2022-12-12 09:23:10
 */
public class P1781_SumOfBeautyOfAllSubstrings {
    public static void main(String[] args) {
        Solution solution = new P1781_SumOfBeautyOfAllSubstrings().new Solution();
        solution.beautySum("xzvfsppsjfbxdwkqe");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautySum(String s) {
            int ans = 0, n = s.length();
            char[] cs = s.toCharArray();
            int[] f = new int[26];
            for (int i = 0; i < n; i++) {
                ++f[cs[i] - 'a'];
                int cur = getNum(f), j = 0;
                ans += cur;
                int[] temp = f.clone();
                while (j < i) {
                    --temp[cs[j++] - 'a'];
                    cur = getNum(temp);
                    ans += cur;
                }
            }
            return ans;
        }

        private int getNum(int[] f) {
            int min = 510, max = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, f[i]);
                min = f[i] == 0 ? min : Math.min(min, f[i]);
            }
            return max - min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}