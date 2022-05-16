package com.tree.middle;

import com.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderSuccessor {

    /**
     * 根据搜索二叉树的性质，左节点的值一定比父节点小，右节点的值一定比父节点大
     * 如果p存在右子树q，那么它的后继者，就是q中的最小节点
     * 如果p不存在右节点，找出比p的val大的第一个节点
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        if (p.right != null) {
            ans = p.right;
            while(ans.left != null) {
                ans = ans.left;
            }
            return ans;
        }
        TreeNode node = root;
        while(node != null) {
            if (node.val > p.val) {
                ans = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode prev = null, cur = root;
        while(!queue.isEmpty() || cur != null) {
            while(cur != null) {
                queue.addLast(cur);
                cur = cur.left;
            }
            cur = queue.pollLast();
            if (prev == p) {
                return cur;
            }
            prev = cur;
            cur = cur.right;
        }
        return null;
    }
}
