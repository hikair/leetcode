package com.tree.middle;

import com.tree.TreeNode;


/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *  
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,10^4]
 * -2^31 <= Node.val <= 2^31 - 1 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindBottomLeftValue {

    int value = 0;
    int height = 0;

    public int findBottomLeftValue(TreeNode root) {
        height = 0;
        dfs(root, 0);
        return value;
    }

    public void dfs(TreeNode node, int h) {
        if (node == null) {
            return;
        }
        h++;
        dfs(node.left, h);
        dfs(node.right, h);
        if (height < h) {
            height = h;
            value = node.val;
        }
    }
}
