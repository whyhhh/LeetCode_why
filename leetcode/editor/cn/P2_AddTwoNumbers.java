package leetcode.editor.cn;

/**
 * 两数相加
 *
 * @author why
 * @date 2022-10-27 14:59:30
 */
public class P2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2_AddTwoNumbers().new Solution();
        ListNode node1 = new P2_AddTwoNumbers().new ListNode(9);
        node1.next = new P2_AddTwoNumbers().new ListNode(9);
        node1.next.next = new P2_AddTwoNumbers().new ListNode(9);

        ListNode node2 = new P2_AddTwoNumbers().new ListNode(9);
        node2.next = new P2_AddTwoNumbers().new ListNode(9);
        node2.next.next = new P2_AddTwoNumbers().new ListNode(9);
        node2.next.next.next = new P2_AddTwoNumbers().new ListNode(9);
        node2.next.next.next.next = new P2_AddTwoNumbers().new ListNode(9);

        solution.addTwoNumbers(node1, node2);
    }

    // Definition for singly-linked list.
    public class ListNode {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ans = new ListNode();
            ListNode node = ans;
            int cur = 0;
            while (l1 != null && l2 != null) {
                cur += (l1.val + l2.val);
                node.val = cur % 10;
                cur = cur / 10;
                node.next = new ListNode();
                if (l1.next == null && l2.next == null && cur == 0) node.next = null;
                node = node.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                cur += l1.val;
                node.val = cur % 10;
                cur = cur / 10;
                node.next = new ListNode();
                if (l1.next == null && cur == 0) node.next = null;
                node = node.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                cur += l2.val;
                node.val = cur % 10;
                cur = cur / 10;
                node.next = new ListNode();
                if (l2.next == null && cur == 0) node.next = null;
                node = node.next;
                l2 = l2.next;
            }
            if (node != null) node.val = 1;

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}