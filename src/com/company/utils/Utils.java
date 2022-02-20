package com.company.utils;

import com.company.leetcode.domain.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Utils {

    public static void print(int[]... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public static void printMatrix(int[][] a) {
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // Generates an array of random values where every number is between
    // [min, max) and there are possible repeats.
    public static int[] randomIntegerArray(int sz, int min, int max) {
        int[] ar = new int[sz];
        for (int i = 0; i < sz; i++) ar[i] = randValue(min, max);
        return ar;
    }

    // Generates an array of random values where every number is between
    // [min, max) and there are possible repeats.
    public static long[] randomLongArray(int sz, long min, long max) {
        long[] ar = new long[sz];
        for (int i = 0; i < sz; i++) ar[i] = randValue(min, max);
        return ar;
    }

    // Generates a list of random values where every number is between
    // [min, max) and there are possible repeats.
    public static List<Integer> randomIntegerList(int sz, int min, int max) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(randValue(min, max));
        return lst;
    }

    // Generates a list of shuffled values where every number in the array
    // is in the range of [0, sz)
    public static List<Integer> randomUniformUniqueIntegerList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(i);
        Collections.shuffle(lst);
        return lst;
    }

    // Generates a random number between [min, max)
    public static int randValue(int min, int max) {
        return min + (int) (Math.random() * ((max - min)));
    }

    // Generates a random number between [min, max)
    public static long randValue(long min, long max) {
        return min + (long) (Math.random() * ((max - min)));
    }

    public static ListNode newListNode(int[] ints) {
        ListNode head = null, prev = null, cur;
        if (ints != null && ints.length != 0) {
            head = new ListNode();
            cur = head;
            for (int i : ints) {
                cur.val = i;
                cur.next = new ListNode();
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
        }
        return head;
    }

    public static void print(ListNode node1) {
        if (node1 != null) {
            System.out.print(node1.val);
            System.out.print(" -> ");
            print(node1.next);
        }
    }

    public static void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
