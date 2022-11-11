package leetcode.editor.cn;

/**
 * 判断字符串的两半是否相似
 *
 * @author why
 * @date 2022-11-11 23:29:40
 */
public class P1704_DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        Solution solution = new P1704_DetermineIfStringHalvesAreAlike().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean halvesAreAlike(String s) {
            int n = s.length();
            char[] are = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (s.charAt(i) == are[j]) {
                        if (i < n / 2) {
                            num++;
                        } else {
                            num--;
                        }
                    }
                }
            }
            return num == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}