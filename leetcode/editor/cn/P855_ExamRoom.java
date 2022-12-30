package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 考场就座
 *
 * @author why
 * @date 2022-12-30 10:39:06
 */
public class P855_ExamRoom {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ExamRoom {
        int N;
        TreeSet<Integer> students;

        public ExamRoom(int n) {
            this.N = n;
            students = new TreeSet<>();
        }

        public int seat() {
            int student = 0;
            if (students.size() > 0) {
                //第一个被坐的位置和0位置距离
                int dist = students.first();
                //当前位置的上一个被坐的位置
                Integer prev = null;
                for (Integer s : students) {
                    //左边有位置
                    if (prev != null) {
                        int d = (s - prev) / 2;
                        //找到位置差距最大的数
                        if (d > dist) {
                            dist = d;
                            student = prev + d;
                        }
                    }
                    prev = s;
                }

                //最后一个位置和最后一个被坐的位置的距离
                if (N - 1 - students.last() > dist) student = N - 1;
            }

            students.add(student);
            return student;
        }

        public void leave(int p) {
            students.remove(p);
        }
    }

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)

}