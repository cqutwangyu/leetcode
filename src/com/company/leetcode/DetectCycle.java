package com.company.leetcode;

import com.company.leetcode.domain.ListNode;
import com.company.utils.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * <p>
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
 * 链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围在范围 [0, 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * <p>
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 * Related Topics 哈希表 链表 双指针 👍 1406 👎 0
 * 招银考到这题
 * @author 王渔
 * @date 2022/3/2 19:06
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode listNode = Utils.newListNode(new int[]{3, 2, 0, -4});
        ListNode last = listNode;
        while (last.next != null) {
            last = last.next;
        }
        last.next = listNode.next;
        System.out.println(new Solution().detectCycle(listNode));
    }

    /**
     * 可利用集合或深度递归进行暴力解
     * 最优解是快慢指针
     */
    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                //slow走一步
                slow = slow.next;
                //fast走两步
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    //fast存在next为空则说明不形成环
                    return null;
                }
                //快慢指针相遇说明存在环（存在环一定会相遇）
                if (slow == fast) {
                    //找环的入口，fast指针从head重新出发，变为一次走一步追赶slow指针
                    fast = head;
                    //从相遇点，和头结点一起出发，每次走一步，再相遇的点一定是环入口
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            return null;
        }

        public ListNode detectCycle1(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.add(head)) {
                    head = head.next;
                } else {
                    return head;
                }
            }
            return null;
        }

    }
}
