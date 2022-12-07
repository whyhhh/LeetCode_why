package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 *
 * @author why
 * @date 2022-12-07 23:13:42
 */
public class P93_RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93_RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("101023");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s.length() < 4 || s.length() > 12) return ans;
            dfs(s, 0, "");
            return ans;
        }

        void dfs(String s, int i, String ip) {
            if (i >= 4) {
                if ("".equals(s)) {
                    ans.add(ip.substring(0, ip.length() - 1));
                }
            } else if ("".equals(s)) {

            } else {
                int n = s.charAt(0) == '0' ? 1 : 3;
                for (int j = 1; j <= n && j <= s.length(); j++) {
                    String temp = s.substring(0, j);
                    if (Integer.parseInt(temp) <= 255) {
                        s = s.substring(j);
                        dfs(s, i + 1, ip + temp + ".");
                        s = temp + s;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}