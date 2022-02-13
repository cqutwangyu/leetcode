package com.company.leetcode;

/**
 * 190.颠倒二进制位<p>
 * Reverse bits of a given 32 bits unsigned integer.
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as a signed integer type.
 * They should not affect your implementation, as the integer's internal binary
 * representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 2 above, the input represents the signed integer -3
 * and the output represents the signed integer -1073741825.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100
 * represents the unsigned integer 43261596, so return 964176192 which its binary
 * representation is 00111001011110000010100101000000.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101
 * represents the unsigned integer 4294967293, so return 3221225471 which its binary
 * representation is 10111111111111111111111111111111.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The input must be a binary string of length 32
 * <p>
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 * Related Topics 位运算 分治 👍 491 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 21:57
 */
public class ReverseBits {
    public static void main(String[] args) {
        new Solution().reverseBits(Integer.parseInt("00000010100101000001111010011100", 2));
    }

    public static class Solution {
        // you need treat n as an unsigned value

        /**
         * 输入一个n
         * 定义一个ret
         * 通过n&1取出n的最后一位，并且n右移一位
         * ret左移一位并|lastBit,把n的最后一位加到ret的最后一位，经过左移就实现了颠倒
         */
        public int reverseBits(int n) {
            int ret = 0;
            int count = 32;
            while (count-- > 0) {
                //获取 n 最后一位
//                int lastBit = n & 1;
                //将结果左移一位后再添加 n 的最后一位
                ret = ret << 1 | (n & 1);
                // n 右移来减少一位
                n = n >> 1;
            }
            return ret;
        }

        /**
         * JavaAPI的实现
         */
        public int reverseBits1(int n) {
//            i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
//            i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
//            i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
//            i = (i << 24) | ((i & 0xff00) << 8) |
//                    ((i >>> 8) & 0xff00) | (i >>> 24);
//            return i;
            return Integer.reverse(n);
        }
    }
}
