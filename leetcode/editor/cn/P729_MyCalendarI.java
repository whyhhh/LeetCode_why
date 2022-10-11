package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 我的日程安排表 I
 *
 * @author why
 * @date 2022-10-11 14:07:02
 */
public class P729_MyCalendarI {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
      class MyCalendar {
        TreeSet<Integer> set;
        Map<Integer, String> map;
        String START = "start";
        String END = "end";

        public MyCalendar() {
            set = new TreeSet<>();
            map = new HashMap<>();
        }

        public boolean book(int start, int end) {
            Integer startCeil = set.ceiling(start);
            Integer startFloor = set.floor(start);
            Integer endFloor = set.floor(end - 1);
            //比start大的数小于end
            if (startCeil != null && startCeil < end - 1) {
                return false;
            }
            //比end小的数大start
            if (endFloor != null && endFloor >= start) {
                return false;
            }
            //比start小的数是起始位置
            if (startFloor != null && map.get(startFloor).equals(START)) {
                return false;
            }
            if (start != end - 1) {
                set.add(start);
                set.add(end - 1);
                map.put(start, START);
                map.put(end - 1, END);
            } else {
                set.add(start);
                map.put(start, END);
            }
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
