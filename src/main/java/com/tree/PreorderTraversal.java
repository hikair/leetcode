package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PreorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null) {
            list.add(root.val);

            if(root.left != null) {
                preorderTraversal(root.left);
            }

            if(root.right != null) {
                preorderTraversal(root.right);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while(temp != null) {
            stack.push(temp);
            list.add(temp.val);
            temp = temp.left;
        }

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp = node.right;
            while(temp != null) {
                stack.push(temp);
                list.add(temp.val);
                temp = temp.left;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        //System.out.println(preorderTraversal.preorderTraversal(new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))));;
        System.out.println(preorderTraversal.preorderTraversal2(new TreeNode(1,new TreeNode(2,new TreeNode(5),new TreeNode(6)),new TreeNode(3,new TreeNode(4),null))));;
    }
}
