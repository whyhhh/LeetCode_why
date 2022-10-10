package leetcode.editor.cn;

/**
 * 检查二进制字符串字段
 * @author why
 * @date 2022-10-10 17:54:23
 */
public class P1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes{
    public static void main(String[] args) {
        Solution solution = new P1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes().new Solution();
        
    }
	 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag&&s.charAt(i)=='0'){
                flag = false;
            }
            if (!flag&&s.charAt(i)=='1'){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
