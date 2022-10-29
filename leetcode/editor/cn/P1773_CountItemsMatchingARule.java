package leetcode.editor.cn;

import java.util.List;

/**
 * 统计匹配检索规则的物品数量
 *
 * @author why
 * @date 2022-10-29 23:37:29
 */
public class P1773_CountItemsMatchingARule {
    public static void main(String[] args) {
        Solution solution = new P1773_CountItemsMatchingARule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int ans = 0, idx = ruleKey.charAt(0) == 't' ? 0 : ruleKey.charAt(0) == 'c' ? 1 : 2;
            for (List<String> item : items) {
                if (item.get(idx).equals(ruleValue)) ans++;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}