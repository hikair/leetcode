package com.tree.middle;

import com.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 * <p>
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数量范围为 [1, 1000] 
 * 0 <= Node.val <= 5000
 * root 是完全二叉树
 * 0 <= val <= 5000 
 * 每个测试用例最多调用 insert 和 get_root 操作 10^4 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/complete-binary-tree-inserter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CBTInserter {

    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new ArrayDeque<>();
        initQueue();
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = queue.peek();
        int ans = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            queue.poll();
        }
        queue.add(child);
        return ans;

    }

    public TreeNode get_root() {
        return root;
    }

    private void initQueue() {
        Queue<TreeNode> temp = new ArrayDeque<>();
        temp.add(root);
        while(!temp.isEmpty()) {
            TreeNode node = temp.poll();
            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }
            if (node.left == null || node.right == null) {
                queue.add(node);
            }
        }
    }
}