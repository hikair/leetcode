package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null) {
            if(root.left != null) {
                inorderTraversal(root.left);
            }

            list.add(root.val);

            if(root.right != null) {
                inorderTraversal(root.right);
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            temp = node.right;
            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
        }
        return list;
    }

    public void inorderStack(TreeNode root) {

    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        //System.out.println(inorderTraversal.inorderTraversal(null));
        //System.out.println(inorderTraversal.inorderTraversal(new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))));
        System.out.println(inorderTraversal.inorderTraversal2(new TreeNode(1,new TreeNode(2),new TreeNode(3,new TreeNode(4),null))));
        //System.out.println(inorderTraversal.inorderTraversal(new TreeNode(1,new TreeNode(2),null)));
        //System.out.println(inorderTraversal.inorderTraversal2(new TreeNode(1,null,new TreeNode(2))));
    }
}
