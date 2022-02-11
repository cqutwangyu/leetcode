package com.company.leetcode;

import com.company.leetcode.domain.ListNode;

import java.util.List;

/**
 * 206.反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * Related Topics 递归 链表 👍 2239 👎 0
 *
 * @author 王渔
 * @date 2022/1/29 21:29
 */
public class ReverseLinkedList {
    class Solution {

        /**
         * 三个值：pev、cur、next
         * pev一开始为空
         * cur指向pev，并作为下一次的pev，直到cur为空
         * next作为下一次的cur
         */
        public ListNode reverseList(ListNode head) {
            //上一个节点（也是最终返回的对象）
            ListNode pev = null;
            //当前节点
            ListNode cur = head;
            //当前节点不为空则说明没到最后，当前节点为空则说明pev是最后一个节点
            while (cur != null) {
                //取出下一个节点
                ListNode next = cur.next;
                //当前节点指向上一个节点
                cur.next = pev;
                //上一个节点赋值为当前节点
                pev = cur;
                //当前节点赋值为下一个节点
                cur = next;
            }
            return pev;
        }
    }
}
