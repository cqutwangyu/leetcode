package com.company.leetcode;

import com.company.leetcode.domain.ListNode;

/**
 * 2.两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * Related Topics 递归 链表 数学 👍 7498 👎 0
 *
 * @author 王渔
 * @date 2022/1/25 22:58
 */
public class AddTwoNumbers {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = packageMethod(l1, l2);
            l2 = null;//help gc
            return l1;
        }

        /**
         * 链表头是低位，链表尾是高位
         * 记录低位的进位，加入高位求和
         * 从低到高，依次创建新链表
         */
        public ListNode packageMethod(ListNode l1, ListNode l2) {
            ListNode root = null, parent = null, node;
            int result;
            boolean carry = false;
            while (l1 != null || l2 != null) {
                //求和并往后指
                if (l1 != null && l2 != null) {
                    result = l1.val + l2.val;
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1 != null) {
                    result = l1.val;
                    l1 = l1.next;
                } else {
                    result = l2.val;
                    l2 = l2.next;
                }

                //进位处理
                if (carry) {
                    result += 1;
                    carry = false;
                }
                if (result > 9) {
                    carry = true;
                    result -= 10;
                }

                //构建返回链表
                node = new ListNode(result);
                if (root == null) {
                    parent = node;
                    root = parent;
                } else {
                    parent.next = node;
                    parent = node;
                }
            }
            //最后一次进位
            if (carry) {
                node = new ListNode(1);
                parent.next = node;
            }
            parent = null;//help gc
            node = null;//help gc
            return root;
        }

    }

}
