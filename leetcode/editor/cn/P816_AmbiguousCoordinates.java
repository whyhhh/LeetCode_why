package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 模糊坐标
 *
 * @author why
 * @date 2022-11-30 17:48:55
 */
public class P816_AmbiguousCoordinates {
    public static void main(String[] args) {
        Solution solution = new P816_AmbiguousCoordinates().new Solution();
        solution.ambiguousCoordinates("(123)");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String s;

        public List<String> ambiguousCoordinates(String _s) {
            //s为_s去掉首字母
            s = _s.substring(1, _s.length() - 1);
            //n为s长度
            int n = s.length();
            List<String> ans = new ArrayList<>();
            //枚举逗号：在 i 的后面追加逗号
            for (int i = 0; i < n - 1; i++) {
                List<String> a = search(0, i), b = search(i + 1, n - 1);
                for (String x : a) {
                    for (String y : b) {
                        ans.add("(" + x + ", " + y + ")");
                    }
                }
            }
            return ans;
        }

        List<String> search(int start, int end) {
            List<String> ans = new ArrayList<>();
            if (start == end || s.charAt(start) != '0') ans.add(s.substring(start, end + 1));
            for (int i = start; i < end; i++) { // 枚举小数点：在 i 后面追加小数点
                String a = s.substring(start, i + 1), b = s.substring(i + 1, end + 1);
                if (a.length() > 1 && a.charAt(0) == '0') continue;
                if (b.charAt(b.length() - 1) == '0') continue;
                ans.add(a + "." + b);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}