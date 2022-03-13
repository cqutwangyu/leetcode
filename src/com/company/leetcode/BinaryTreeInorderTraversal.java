package com.company.leetcode;

import com.company.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 5：
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Related Topics 栈 树 深度优先搜索 二叉树 👍 1309 👎 0
 *
 * @author 王渔
 * @date 2022/3/13 22:30
 */
public class BinaryTreeInorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        List<Integer> list = new ArrayList<>();

        /**
         * 递归
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root != null) {
                inorderTraversal(root.left);
                list.add(root.val);
                inorderTraversal(root.right);
            }
            return list;
        }

        /**
         * 递归思想迭代
         */
        public List<Integer> inorderTraversal1(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stk = new LinkedList<>();
            while (root != null || !stk.isEmpty()) {
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }

        /**
         * Morris中序遍历
         */
        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            TreeNode predecessor = null;

            while (root != null) {
                if (root.left != null) {
                    // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }

                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    // 说明左子树已经访问完了，我们需要断开链接
                    else {
                        res.add(root.val);
                        predecessor.right = null;
                        root = root.right;
                    }
                }
                // 如果没有左孩子，则直接访问右孩子
                else {
                    res.add(root.val);
                    root = root.right;
                }
            }
            return res;
        }

    }
}
