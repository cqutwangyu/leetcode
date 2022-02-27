package com.company.leetcode;

/**
 * 844. 比较含退格的字符串
 * <p>
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * Related Topics 栈 双指针 字符串 模拟 👍 366 👎 0
 *
 * @author 王渔
 * @date 2022/2/21 23:31
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
    }

    static class Solution {
        public boolean backspaceCompare(String s, String t) {
            int i = s.length() - 1, j = t.length() - 1;
            int skipS = 0, skipT = 0;

            //从后往前比
            while (i >= 0 || j >= 0) {
                while (i >= 0) {
                    if (s.charAt(i) == '#') {//遇到#跳过cur，且next跳过
                        skipS++;
                        i--;
                    } else if (skipS > 0) {//跳过next
                        skipS--;
                        i--;
                    } else {//i是有效值
                        break;
                    }
                }
                while (j >= 0) {
                    if (t.charAt(j) == '#') {//遇到#跳过cur，且next跳过
                        skipT++;
                        j--;
                    } else if (skipT > 0) {//跳过next
                        skipT--;
                        j--;
                    } else {//j是有效值
                        break;
                    }
                }
                //i和j都是有效值
                if (i >= 0 && j >= 0) {
                    //如果i和j的cur有效值不一样，则结果为false
                    if (s.charAt(i) != t.charAt(j)) {
                        return false;
                    }
                } else {//i和j中存在下标出界了
                    //其中存在下标不出界的，说明结果的长度不一样，则结果为false
                    if (i >= 0 || j >= 0) {
                        return false;
                    }
                }
                i--;
                j--;
            }
            //最终i和j都小于0了，且比较过的每一个有效值都相同，则结果为true
            return true;
        }

        public boolean backspaceCompare1(String s, String t) {
            return build(s).equals(build(t));
        }

        private String build(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '#') {
                    sb.append(s.charAt(i));
                } else if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            return sb.toString();
        }
    }
}
