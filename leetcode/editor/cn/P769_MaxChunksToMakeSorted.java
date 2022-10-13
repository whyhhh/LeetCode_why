package leetcode.editor.cn;


/**
 * 最多能完成排序的块
 *
 * @author why
 * @date 2022-10-13 11:36:34
 */
public class P769_MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new P769_MaxChunksToMakeSorted().new Solution();
        solution.maxChunksToSorted(new int[]{1,0,2,3,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int ans = 0, n = arr.length;
            for (int i = 0; i < n; i++) {
                if (arr[i] > i) {
                    int max = arr[i];
                    while (i < max) max = Math.max(arr[++i], max);
                    ans++;
                }else if (arr[i]==i){
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}