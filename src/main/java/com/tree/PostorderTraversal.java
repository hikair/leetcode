package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PostorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null) {
            if(root.left != null) {
                postorderTraversal(root.left);
            }

            if(root.right != null) {
                postorderTraversal(root.right);
            }

            list.add(root.val);
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while(temp != null) {
            stack.push(temp);
            list.addFirst(temp.val);
            temp = temp.right;
        }

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp = node.left;
            while(temp != null) {
                stack.push(temp);
                list.addFirst(temp.val);
                temp = temp.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        System.out.println(postorderTraversal.postorderTraversal2(new TreeNode(1,new TreeNode(2,new TreeNode(5),new TreeNode(6)),new TreeNode(3,new TreeNode(4),null))));
    }
}
