package leetcode.editor.cn;

import java.util.*;

/**
 * 连接词
 *
 * @author why
 * @date 2022-11-22 10:48:41
 */
public class P472_ConcatenatedWords {
    public static void main(String[] args) {
        Solution solution = new P472_ConcatenatedWords().new Solution();
        solution.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Long> set = new HashSet<>();

        //增大各个单词hash值的偏移量
        int P = 131, OFFSET = 128;

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            for (String s : words) {
                long hash = 0;
                for (char c : s.toCharArray()) hash = hash * P + (c - 'a') + OFFSET;
                set.add(hash);
            }
            List<String> ans = new ArrayList<>();
            for (String s : words) {
                if (check(s)) ans.add(s);
            }
            return ans;
        }

        boolean check(String s) {
            int n = s.length();
            int[] f = new int[n + 1];
            Arrays.fill(f, -1);
            f[0] = 0;
            for (int i = 0; i <= n; i++) {
                //不是-1时说明此位置前可以由字串构成，个数为f[i]
                if (f[i] == -1) continue;
                long cur = 0;
                for (int j = i; j < n; j++) {
                    cur = cur * P + (s.charAt(j) - 'a') + OFFSET;
                    //存在单词，则后一位记录状态，单词数+1
                    if (set.contains(cur)) f[j + 1] = Math.max(f[j + 1], f[i] + 1);
                }
                //包含至少两个单词
                if (f[n] > 1) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}