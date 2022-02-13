package com.company.leetcode;

/**
 * 231. 2的幂
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * An integer n is a power of two, if there exists an integer x such that n == 2
 * ˣ.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 2⁰ = 1
 * <p>
 * Example 2:
 * <p>
 * Input: n = 16
 * Output: true
 * Explanation: 2⁴ = 16
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -2³¹ <= n <= 2³¹ - 1
 * <p>
 * <p>
 * Follow up: Could you solve it without loops/recursion? Related Topics 位运算 递归 数
 * 学 👍 458 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 21:23
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        new Solution().isPowerOfTwo1(8);
    }

    static class Solution {

        public boolean isPowerOfTwo(int n) {
            if (n == 1) return true;
            if (n == 0) return false;
            if (n % 2 != 0) return false;
            return isPowerOfTwo(n / 2);
        }


        /**
         * 重点在于对位运算符的理解
         * 解法1：&运算，同1则1。 return (n > 0) && (n & -n) == n;
         * 解释：2的幂次方在二进制下，只有1位是1，其余全是0。例如:8---00001000。负数的在计算机中二进制表示为补码(原码->正常二进制表示，原码按位取反(0-1,1-0)，最后再+1。然后两者进行与操作，得到的肯定是原码中最后一个二进制的1。例如8&(-8)->00001000 & 11111000 得 00001000，即8。 建议自己动手算一下，按照这个流程来一遍，加深印象。
         * 解法2：移位运算：把二进制数进行左右移位。左移1位，扩大2倍；右移1位，缩小2倍。 return (n>0) && (1<<30) % n == 0;
         * 解释：1<<30得到最大的2的整数次幂，对n取模如果等于0，说明n只有因子2。
         * @param n
         * @return
         */
        public boolean isPowerOfTwo1(int n) {
            /**
             * 输入为8时
             *    8:11111111111111111111111111111000
             *   -8:00000000000000000000000000001000
             * 8&-n:00000000000000000000000000001000
             * 输入为9时
             *    9:11111111111111111111111111110111
             *   -9:00000000000000000000000000001001
             * 9&-9:00000000000000000000000000000001
             */
            return (n > 0) && (n & -n) == n;
        }

        public boolean isPowerOfTwo2(int n) {
            return (n > 0) && (1 << 30) % n == 0;
        }
    }
}
