package leetcode.editor.cn;


/**
 * 链表组件
 *
 * @author why
 * @date 2022-10-12 09:29:09
 */
public class P817_LinkedListComponents {
    public static void main(String[] args) {
        Solution solution = new P817_LinkedListComponents().new Solution();
        ListNode node = new ListNode();
        node.val = 0;
        int[] nums = new int[]{0};
        solution.numComponents(node, nums);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numComponents(ListNode head, int[] nums) {
            int ans = 0;
            int[] idx = new int[10*10*10*10];
            for (int num : nums) {
                idx[num] = 1;
            }
            while (head != null) {
                while (head != null&&idx[head.val]==0) head = head.next;
                if (head != null && idx[head.val]==1) {
                    ans++;
                    while (head != null && idx[head.val]==1) head = head.next;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
