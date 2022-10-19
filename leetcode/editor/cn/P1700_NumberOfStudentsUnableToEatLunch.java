package leetcode.editor.cn;

/**
 * 无法吃午餐的学生数量
 *
 * @author why
 * @date 2022-10-19 17:22:18
 */
public class P1700_NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        Solution solution = new P1700_NumberOfStudentsUnableToEatLunch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int[] student = new int[2];
            for (int i = 0; i < students.length; i++) {
                student[students[i]]++;
            }
            for (int i = 0; i < sandwiches.length; i++) {
                if (student[sandwiches[i]] == 0) {
                    return student[0] + student[1];
                }
                student[sandwiches[i]]--;
            }
            return student[0] + student[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}