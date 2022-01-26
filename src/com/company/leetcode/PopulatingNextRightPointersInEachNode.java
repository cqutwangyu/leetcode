package com.company.leetcode;

import com.company.leetcode.domain.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
 * next 指针连接，'#' 标志着每一层的结束。
 * <p>
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 2¹² - 1] 范围内
 * -1000 <= node.val <= 1000
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 658 👎 0
 * //leetcode submit region begin(Prohibit modification and deletion)
 * Definition for a Node.
 * ass Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node next;
 *
 * @author 王渔
 * @date 2022/1/26 23:26
 */
public class PopulatingNextRightPointersInEachNode {

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            dfs(root);
            return root;
        }

        private void dfs(Node root) {
            if (root == null) {
                return;
            }
            //当前节点的左右子节点
            Node left = root.left;
            Node right = root.right;
            //配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
            while (left != null) {
                //左节点指向右节点
                left.next = right;
                //左节点指向right、右节点指向left、左右节点一定相邻
                //循环起来之后就是左子树的右节点指向了右子树的左节点，直到左节点为空
                left = left.right;
                right = right.left;
            }
            //递归的调用左右节点，完成同样的纵深串联
            dfs(root.left);
            dfs(root.right);
        }
    }
}
