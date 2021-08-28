package com.tree;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCousins {


    public int deepNode(TreeNode node, int n, int deep) {
        if(node != null){
            if(node.val == n){
                return deep;
            }
            int l = deepNode(node.left, n , deep + 1);
            int r = deepNode(node.right, n , deep + 1);
            return l == -1 ? r : l;
        }
        return -1;
    }

    /**
     * 获取深度
     * @return
     */
    public int getDeep(TreeNode root, int n, int deep) {

        if(root.val==n) {
            return deep;
        }

        int left = getDeep(root, n, deep + 1);


        return 0;
    }

    /**
     * 获取父节点
     * @return
     */
    public int getFather() {
        return 0;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode nodeX = findTreeNodeByValue(root, x);
        TreeNode nodeY = findTreeNodeByValue(root, y);




        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        root.left = child1;
        root.right = child2;
        TreeNode grandSon1 = new TreeNode(4);
        TreeNode grandSon2 = new TreeNode(5);
        child1.right = grandSon1;
        child2.right = grandSon2;


        IsCousins isCousins = new IsCousins();
        //boolean cousins = isCousins.isCousins(root, 5, 4);
        int i = isCousins.deepNode(root, 5, 0);
        System.out.println(i);

    }

    public TreeNode findTreeNodeByValue(TreeNode node,int value) {
        if(node == null) {
            return null;
        }

        if(node.val == value) {
            return node;
        }

        TreeNode result = findTreeNodeByValue(node.left, value);
        if(result != null) {
            return result;
        }

        return findTreeNodeByValue(node.right, value);
    }
}
