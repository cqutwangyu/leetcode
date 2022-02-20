package com.company.leetcode;

import com.company.leetcode.domain.ListNode;
import com.company.utils.Utils;

/**
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * Related Topics 链表 双指针 👍 810 👎 0
 *
 * @author 王渔
 * @date 2022/2/20 20:36
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode node = Utils.newListNode(new int[]{1, 1, 3, 3, 4, 4, 4});
        ListNode node1 = new Solution().deleteDuplicates(node);
        Utils.print(node1);
    }

    static class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            //虚拟头节点
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode prev = dummyHead;
            ListNode cur = prev.next;
            while (cur != null) {
                // 当前数的出现数量
                int curRepeatNum = 1;

                // 找到和cur指向的结点值不同的结点
                ListNode difNode = cur.next;
                while (difNode != null && difNode.val == cur.val) {
                    curRepeatNum++;
                    difNode = difNode.next;
                }

                // 如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
                if (curRepeatNum > 1) {
                    //上一个节点直接跳过重复数，指向非重复结点
                    prev.next = difNode;
                } else {
                    // cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
                    prev = cur;
                }
                // 从非重复数开始继续遍历
                cur = difNode;
            }
            return dummyHead.next;

        }

    }
}
