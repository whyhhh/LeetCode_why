package leetcode.editor.cn;

/**
 * 替换后的最长重复字符
 *
 * @author why
 * @date 2022-12-02 23:41:01
 */
public class P424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new P424_LongestRepeatingCharacterReplacement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            char[] cs = s.toCharArray();
            int[] cnt = new int[26];
            int ans = 0;
            for (int l = 0, r = 0; r < s.length(); r++) {
                //滑动窗口添加元素
                cnt[cs[r] - 'A']++;
                //如果窗口内总元素-最大元素>k,则窗口不满足条件，左边界递减，直到满足条件
                while (!check(cnt, k)) cnt[cs[l++] - 'A']--;

                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }

        boolean check(int[] cnt, int k) {
            int max = 0, sum = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, cnt[i]);
                sum += cnt[i];
            }
            return sum - max <= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
