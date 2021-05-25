//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 1004 👎 0

package com.hang.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            /* 1.暴力解 */
//            if (head == null || head.next == null) {
//                return null;
//            }
//            HashSet<ListNode> set = new HashSet<>();
//            ListNode cur = head;
//            while (cur.next != null) {
//                if (!set.add(cur)) {
//                    return cur;
//                }
//                cur = cur.next;
//            }
//            return null;
//        }
            /* 2.快慢指针 */
            /* fast 和 slow 同时从头结点出发，fast一次走2，slow一次走1 */
            /* 设从头节点到环形入口的距离为a，环形的长度为b */
            /* 当fast 和 slow 在环中相遇时，设fast走过f，slow走过s，则 f = 2s */
            /* 设fast超过slow n 圈，则 f = s + nb */
            /* 则 s = nb，f = 2nb，从头结点开始走 a + nb 的距离可以到达环形入口 */
            /* 则 slow 再走a即可到达环形入口，那么这时我们让一个指针从头节点开始和slow一样一次走一步，即可在环形入口相会 */
            if (head == null || head.next == null) {
                return null;
            }
            ListNode fast = head, slow = head, p = head;
            do {
                slow = slow.next;
                fast = fast.next.next;
            } while (fast != slow && fast != null && fast.next != null);
            if (slow == fast) {
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
            } else {
                return null;
            }
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}