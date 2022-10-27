package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Objects;

/**
 * 相交链表
 *
 * @author why
 * @date 2022-10-26 17:50:10
 */

public class P160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new P160_IntersectionOfTwoLinkedLists().new Solution();
    }


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int n1 = 0, n2 = 0;
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            while (nodeA.next != null) {
                n1++;
                nodeA = nodeA.next;
            }
            while (nodeB.next != null) {
                n2++;
                nodeB = nodeB.next;
            }
            int gap = 0;
            gap = Math.abs(n1 - n2);
            if (n1 > n2) {
                while (gap-- > 0) {
                    headA = headA.next;
                }
            } else {
                while (gap-- > 0) {
                    headB = headB.next;
                }
            }
            while (headA != null && headB != null) {
                if (headA.equals(headB)) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}