package com.company.leetcode;

import com.company.leetcode.domain.ListNode;

/**
 * 21.合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * Related Topics 递归 链表 👍 2166 👎 0
 *
 * @author 王渔
 * @date 2022/1/29 21:04
 */
public class MergeTwoSortedLists {
    class Solution {
        /**
         * 将两个升序链表按升序合并，并返回链表
         * 比较两个链表的节点大小，那个节点值小，就取那个节点
         * 被添加过的节点则指向自己的下一个节点，进入下一次比较
         * 利用递归的压栈特性，最终返回结果是第一次入栈时所需要return的那个链表
         * <p>
         * 两个升序链表，合并为一个新的升序链表
         * 小的在前面，大的在后面
         * 比较root的值大小，小的作为return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //两个链表判空return
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            // 谁小谁先，进入递归
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
