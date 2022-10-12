package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 数组中两个数的最大异或值
 *
 * @author why
 * @date 2022-10-11 17:17:53
 */
public class P421_MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        Solution solution = new P421_MaximumXorOfTwoNumbersInAnArray().new Solution();
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Node {
            Node[] son = new Node[2];
        }

        Node root = new Node();

        void add(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int a = (num >> i) & 1;
                if (node.son[a] == null) node.son[a] = new Node();
                node = node.son[a];
            }
        }

        int getMax(int num) {
            Node node = root;
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                int a = (num >> i) & 1, b = 1 - a;
                if (node.son[b] == null) {
                    ans |= (a << i);
                    node = node.son[a];
                } else {
                    ans |= (b << i);
                    node = node.son[b];
                }
            }
            return ans;
        }

        public int findMaximumXOR(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                add(num);
                ans = Math.max(ans, num^getMax(num));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
