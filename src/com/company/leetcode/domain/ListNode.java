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

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
