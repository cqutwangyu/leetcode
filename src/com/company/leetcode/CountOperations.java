package com.company.leetcode;

/**
 * 6004.得到0的操作数<p>
 * 给你两个 非负 整数 num1 和 num2 。
 * <p>
 * 每一步 操作中，如果 num1 >= num2 ，你必须用 num1 减 num2 ；否则，你必须用 num2 减 num1 。
 * <p>
 * 例如，num1 = 5 且 num2 = 4 ，应该用num1 减 num2 ，因此，得到 num1 = 1 和 num2 = 4 。然而，如果 num1 = 4且 num2 = 5 ，一步操作后，得到 num1 = 4 和 num2 = 1 。
 * 返回使 num1 = 0 或 num2 = 0 的 操作数 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-operations-to-obtain-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 王渔
 * @date 2022/2/13 10:45
 */
public class CountOperations {

    class Solution {
        public int countOperations(int num1, int num2) {
            return dfs(num1, num2, 0);
        }

        private int dfs(int num1, int num2, int count) {
            if (num1 == 0 || num2 == 0) {
                return count;
            }
            if (num1 >= num2) {
                count = dfs(num1 - num2, num2, count + 1);
            } else {
                count = dfs(num1, num2 - num1, count + 1);
            }
            return count;
        }
    }

}
