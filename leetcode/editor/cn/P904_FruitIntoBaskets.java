package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 水果成篮
 *
 * @author why
 * @date 2022-10-17 09:07:49
 */
public class P904_FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new P904_FruitIntoBaskets().new Solution();
        solution.totalFruit(new int[]{1, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            int ans = 0, tempAns = 0, n = fruits.length;
            int[] box = new int[2];
            box[0] = -1;
            box[1] = -1;

            int l = 0, r = 0;
            while (r < n) {
                if (fruits[r] != box[0] && fruits[r] != box[1] && box[0] != -1 && box[1] != -1) {
                    if (fruits[l] == box[0]) {
                        box[1] = fruits[r];
                    } else {
                        box[0] = fruits[r];
                    }
                    ans = Math.max(tempAns, ans);
                    tempAns = r - l;
                    continue;
                }

                if (box[0] == -1 && box[1] != fruits[r]) box[0] = fruits[r];
                if (box[1] == -1 && box[0] != fruits[r]) box[1] = fruits[r];
                if (box[0] != -1 && box[1] != -1 && fruits[l] != fruits[r]) l = r;
                r++;
                tempAns++;
            }
            ans = Math.max(ans, tempAns);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}