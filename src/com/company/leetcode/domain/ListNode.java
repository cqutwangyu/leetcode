package com.company.leetcode.domain;

/**
 * todo desc
 *
 * @author 王渔
 * @date 2022/1/25 23:02
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
