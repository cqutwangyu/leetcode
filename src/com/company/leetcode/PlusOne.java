package com.company.leetcode;

/**
 * 66. 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * Related Topics 数组 数学 👍 963 👎 0
 *
 * @author 王渔
 * @date 2022/3/28 22:12
 */
public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int index = digits.length;
            //从后往前加
            while (index-- >= 0) {
                //进位
                if (digits[index] == 9) {
                    //十进制，置为零
                    digits[index] = 0;
                    //如果是下标0需要进位，则需要扩展数组
                    if (index == 0) {
                        int[] ints = new int[digits.length + 1];
                        ints[0] = 1;
                        for (int i = 0; i < digits.length; i++) {
                            ints[i + 1] = digits[i];
                        }
                        return ints;
                    }
                } else {
                    //当前下标不需要进位（或右侧下标进位后当前下标不需要进位）
                    ++digits[index];
                    break;
                }
            }
            return digits;
        }
    }
}
