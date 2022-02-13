package com.company.leetcode;

/**
 * 191.位1的个数<p>
 * Write a function that takes an unsigned integer and returns the number of '1'
 * bits it has (also known as the Hamming weight).
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, the input will be given as a signed integer type. It should not
 * affect your implementation, as the integer's internal binary representation is
 * the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 3, the input represents the signed integer. -3.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a
 * total of three '1' bits.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a
 * total of one '1' bit.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a
 * total of thirty one '1' bits.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The input must be a binary string of length 32.
 * <p>
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 * Related Topics 位运算 👍 418 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 21:36
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        new Solution().hammingWeight1(00000000000000000000000000001011);
    }

    public static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            String s = Integer.toBinaryString(n);
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            return count;
        }

        public int hammingWeight1(int n) {
            int cnt = 0;
            for (int i = 0; i < 32; i++) {
                // 2进制右移i次，然后&1，最右侧的一位值是1则返回1
                if (((n >> i) & 1) == 1) {
                    cnt++;
                }
            }
            return cnt;
        }

    }
}
