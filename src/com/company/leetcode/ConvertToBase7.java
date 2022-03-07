package com.company.leetcode;

/**
 * 504. 七进制
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 * <p>
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * 提示：
 * -10⁷ <= num <= 10⁷
 * <p>
 * Related Topics 数学 👍 148 👎 0
 *
 * @author 王渔
 * @date 2022/3/7 14:16
 */
public class ConvertToBase7 {
    public static void main(String[] args) {
        String s = new Solution().convertToBase7(-7);
        System.out.println(s);
    }

    static class Solution {

        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean negative = num < 0;
            if (negative) {
                num = -num;
            }
            StringBuilder digits = new StringBuilder();
            while (num != 0) {
                digits.append(num % 7);
                num /= 7;
            }
            if (negative) {
                digits.append('-');
            }
            return digits.reverse().toString();
        }

        public String myConvertToBase7(int num) {
            Base base = new Base(7);
            String flag = num >= 0 ? "" : "-";
            return flag + base.add(Math.abs(num)).toString();
        }

        class Base {
            int base;
            int val;
            Base parent;

            public Base(int base) {
                this.base = base;
            }

            Base add(int num) {
                if (num < base) {
                    val = num;
                } else {
                    val = num % base;
                    if (parent == null) {
                        parent = new Base(base);
                    }
                    parent.add(num / base);
                }
                return this;
            }

            @Override
            public String toString() {
                return (parent == null ? "" : parent.toString()) + val;
            }
        }
    }

}
