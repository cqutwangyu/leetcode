package com.company.leetcode;

import java.util.*;

/**
 * 589. N叉树前序遍历
 * <p>
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
 * null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * 提示：
 * <p>
 * 节点总数在范围 [0, 10⁴]内
 * 0 <= Node.val <= 10⁴
 * n 叉树的高度小于或等于 1000
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author 王渔
 * @date 2022/3/10 20:09
 */
public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.children.add(new Node(3));
        node.children.add(new Node(2));
        node.children.add(new Node(4));
        node.children.get(0).children.add(new Node(5));
        node.children.get(0).children.add(new Node(6));
        List<Integer> preorder = new Solution().preorder(node);
        System.out.println(Arrays.toString(preorder.toArray()));
    }

    static class Node {
        public int val;
        public List<Node> children = new LinkedList<>();

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    static class Solution {

        List<Integer> ans = new ArrayList<>();

        /**
         * 先序遍历的过程和递归入栈出栈的顺序一致
         */
        public List<Integer> preorder(Node root) {
            dfs(root);
            return ans;
        }

        void dfs(Node root) {
            if (root == null) {
                return;
            }
            ans.add(root.val);
            for (Node node : root.children) {
                dfs(node);
            }
        }

        class Tuple {
            Node node;
            Integer count;

            public Tuple(Node node, Integer count) {
                this.node = node;
                this.count = count;
            }

            @Override
            public String toString() {
                return "node(" + node.val + ").child[" + count + ']';
            }
        }

        /**
         * 迭代
         */
        public List<Integer> preorder1(Node root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            //使用栈模拟递归过程
            Deque<Tuple> d = new ArrayDeque<>();
            //二元组保存{当前节点,当前节点遍历过的子节点数量}
            d.addLast(new Tuple(root, 0));
            while (!d.isEmpty()) {
                System.out.print("answer" + Arrays.toString(ans.toArray()) + " ");
                System.out.println("deque" + Arrays.toString(d.toArray()));
                //从队尾弹出
                Tuple poll = d.pollLast();
                Node cur = poll.node;
                Integer cnt = poll.count;
                //当cnt为0，说明当前节点是第一次出现，加入结果列表中，第二次出现则不加入
                if (cnt == 0) {
                    ans.add(cur.val);
                }
                //出现次数小于当前节点的子节点数量，则添加到队尾后入先出
                if (cnt < cur.children.size()) {
                    //准备访问下一个节点
                    d.addLast(new Tuple(cur, cnt + 1));
                    //子节点入栈，第一次出现
                    d.addLast(new Tuple(cur.children.get(cnt), 0));
                }
            }
            return ans;
        }

        /**
         * 通用迭代
         */
        public List<Integer> preorder2(Node root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Deque<Tuple> d = new ArrayDeque<>();
            d.addLast(new Tuple(root, 0));
            while (!d.isEmpty()) {
                //从队尾弹出
                Tuple poll = d.pollLast();
                Node cur = poll.node;
                Integer cnt = poll.count;
                if (cnt == 0) {
                    ans.add(cur.val);
                    d.addLast(new Tuple(cur, 1));
                } else if (cnt == 1) {
                    int n = cur.children.size();
                    for (int i = n - 1; i >= 0; i--) {
                        //添加到队尾，后入先出
                        d.addLast(new Tuple(cur.children.get(i), 0));
                    }
                }
            }
            return ans;
        }
    }
}
