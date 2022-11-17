package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 匹配子序列的单词数
 *
 * @author why
 * @date 2022-11-17 10:02:29
 */
public class P792_NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P792_NumberOfMatchingSubsequences().new Solution();
        solution.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            Map<Character, List<Integer>> map = new HashMap<>();
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                List<Integer> list = map.getOrDefault(cs[i], new ArrayList<>());
                list.add(i);
                map.put(cs[i], list);
            }
            int ans = 0;
            for (String word : words) {
                char[] cw = word.toCharArray();
                int idx = -1;
                boolean flag = true;
                for (int i = 0; i < cw.length && flag; i++) {
                    List<Integer> list = map.getOrDefault(cw[i],new ArrayList<>());
                    int l = 0, r = list.size() - 1;
                    while (l < r) {
                        int mid = (r - l) / 2 + l;
                        if (list.get(mid) > idx) r = mid;
                        else l = mid + 1;
                    }
                    if (r < 0 || list.get(r) <= idx) flag = false;
                    else idx = list.get(r);
                }
                if (flag) ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}