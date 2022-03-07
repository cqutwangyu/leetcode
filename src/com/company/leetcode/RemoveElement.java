package com.company.leetcode;

/**
 * 27. 移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而
 * nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
 * 的元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * <p>
 * Related Topics 数组 双指针 👍 1212 👎 0
 *
 * @author 王渔
 * @date 2022/3/7 20:11
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        System.out.println(new Solution().removeElement(arr, 3));
        arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Solution().removeElement(arr, 2));
        arr = new int[]{3, 2, 2, 3};
        System.out.println(new Solution().removeElement(arr, 3));
        arr = new int[]{1};
        System.out.println(new Solution().removeElement(arr, 1));
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int count = 0, left = 0, right = nums.length - 1;
            //考虑{1},1的情况
            while (left <= right) {
                //从后往前找到不等于val的下标
                while (right >= 0 && nums[right] == val) {
                    //等于val则移动并计数
                    right--;
                    count++;
                }
                //从前往后找到等于val的下标
                while (nums[left] != val && left < right) {
                    //不等于val则移动
                    left++;
                }
                //下标越界
                if (left >= right || right < 0 || left >= nums.length - 1) {
                    break;
                }
                //交换
                nums[right] = nums[right] + nums[left];
                nums[left] = nums[right] - nums[left];
                nums[right] = nums[right] - nums[left];
            }
            //返回有效长度
            return nums.length - count;
        }

        public int removeElement1(int[] nums, int val) {
            int count = 0, left = 0;
            //从后往前遍历
            for (int right = nums.length - 1; right >= 0; right--) {
                //如果right不是val，则从前往后找一个val与right下标交换
                if (nums[right] != val) {
                    for (int index = left; index < right; index++) {
                        if (nums[index] == val) {
                            //找到一个val值，计数
                            count++;
                            //下次找的起点
                            left = index + 1;
                            //交换两个数
                            nums[right] = nums[right] + nums[index];
                            nums[index] = nums[right] - nums[index];
                            nums[right] = nums[right] - nums[index];
                            //退出内循环
                            break;
                        }
                    }
                } else {
                    //否则就是一个val值，计数
                    count++;
                }
            }
            //总长度减去val的数量就是有效值的长度
            return nums.length - count;
        }
    }
}
