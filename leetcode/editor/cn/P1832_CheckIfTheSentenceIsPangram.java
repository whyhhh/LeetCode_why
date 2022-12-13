package leetcode.editor.cn;

/**
 * 判断句子是否为全字母句
 *
 * @author why
 * @date 2022-12-13 23:08:27
 */
public class P1832_CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {
        Solution solution = new P1832_CheckIfTheSentenceIsPangram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfPangram(String sentence) {
            int[] sums = new int[26];
            int n = sentence.length();
            for (int i = 0; i < n; i++) sums[sentence.charAt(i) - 'a']++;

            for (int i = 0; i < 26; i++) if (sums[i] == 0) return false;

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}