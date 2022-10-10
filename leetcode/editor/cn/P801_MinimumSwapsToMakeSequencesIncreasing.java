package leetcode.editor.cn;

/**
 * 使序列递增的最小交换次数
 * @author why
 * @date 2022-10-10 10:20:54
 */
public class P801_MinimumSwapsToMakeSequencesIncreasing{
    public static void main(String[] args) {
        Solution solution = new P801_MinimumSwapsToMakeSequencesIncreasing().new Solution();
        solution.minSwap(new int[]{1,3,5,4},
                new int[]{1,2,3,7});
    }
	 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i][1] = len;
        }
        for (int i = 1; i < len; i++) {
            if (nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]+1;
            }
            if (nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                dp[i][0] = Math.min(dp[i][0],dp[i-1][1]);
                dp[i][1] = Math.min(dp[i][1],dp[i-1][0]+1);
            }
        }
        return Math.min(dp[len-1][0],dp[len-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
