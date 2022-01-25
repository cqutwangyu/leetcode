package com.company.leetcode;

import com.company.leetcode.domain.ListNode;

/**
 * 2.两数相加
 *
 *
 * @author 王渔
 * @date 2022/1/25 22:58
 */
public class AddTwoNumbers {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = packageMethod(l1, l2);
            l2 = null;
            return l1;
        }

        public ListNode packageMethod(ListNode l1, ListNode l2) {
            ListNode root = null, parent = null, node;
            int result;
            boolean carry = false;
            while (l1 != null || l2 != null) {
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
                if (carry) {
                    result += 1;
                    carry = false;
                }
                if (result > 9) {
                    carry = true;
                    result -= 10;
                }
                node = new ListNode(result);
                if (root == null) {
                    parent = node;
                    root = parent;
                } else {
                    parent.next = node;
                    parent = node;
                }
            }
            if (carry) {
                node = new ListNode(1);
                parent.next = node;
            }
            parent = null;
            node = null;
            return root;
        }

    }

}
