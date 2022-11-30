package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最大频率栈
 *
 * @author why
 * @date 2022-11-30 14:01:18
 */
public class P895_MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack solution = new P895_MaximumFrequencyStack().new FreqStack();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        int max = 0;
        public FreqStack(){

        }

        public void push(int val) {
            cnts.put(val, cnts.getOrDefault(val, 0) + 1);
            //当前值数量
            int num = cnts.get(val);
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(val);
            map.put(num, list);
            max = Math.max(max, num);
        }

        public int pop() {
            List<Integer> list = map.get(max);
            Integer val = list.remove(list.size() - 1);
            cnts.put(val, cnts.get(val) - 1);
            if (list.size() == 0) max--;
            return val;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)

}