//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表 
// 👍 1751 👎 0

package com.hang.leetcode.editor.cn;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            /* 1.迭代 */
//            if (head == null) {
//                return null;
//            }
//            ListNode pre = null, cur = head, next = cur.next;
//            while (cur != null) {
//                cur.next = pre;
//                pre = cur;
//                cur = next;
//                if (next != null) {
//                    next = next.next;
//                }
//            }
//            return pre;

            /* 2.递归 */
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList(head.next);    //获得尾结点
            head.next.next = head;  //让当前递归层级的head的后继的指针指向head
            head.next = null;
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}