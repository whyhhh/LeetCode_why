package leetcode.editor.cn;

/**
 * 最短公共超序列
 *
 * @author why
 * @date 2022-11-23 15:19:44
 */
public class P1092_ShortestCommonSupersequence {
    public static void main(String[] args) {
        Solution solution = new P1092_ShortestCommonSupersequence().new Solution();
        solution.shortestCommonSupersequence("asd", "asfasd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int n = str1.length(), m = str2.length();
            str1 = " " + str1;
            str2 = " " + str2;
            char[] c1 = str1.toCharArray(), c2 = str2.toCharArray();
            int[][] f = new int[n][m];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (c1[i] == c2[j]) f[i][j] = f[i - 1][j - 1] + 1;
                    else f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }


            StringBuilder sb = new StringBuilder();
            int i = n, j = m;
            while (i > 0 || j > 0) {
                // 如果一个数组为0，则将另一个数组所有字符加进入
                if (i == 0) sb.append(c2[j--]);
                else if (j == 0) sb.append(c1[i--]);

                else {
                    //如果两个字符相等，则添加该字符
                    if (c1[i] == c2[j]) {
                        sb.append(c1[i]);
                        i--;
                        j--;

                    } else if (f[i][j] == f[i - 1][j]) {
                        sb.append(c1[i--]);
                    } else {
                        sb.append(c2[j--]);
                    }
                }
            }
            return sb.reverse().toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}