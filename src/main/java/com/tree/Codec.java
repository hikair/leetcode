package com.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        preorderTraversal(root, ans);
        return ans.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String val = list.get(0);
        if ("#".equals(val)) {
            list.remove(0);
            return null;
        }
        TreeNode temp = new TreeNode(Integer.parseInt(val));
        list.remove(0);
        temp.setLeft(deserialize(list));
        temp.setRight(deserialize(list));
        return temp;
    }

    private void preorderTraversal(TreeNode root, StringBuilder ans) {
        ans.append(",");
        if (root == null) {
            ans.append("#");
            return;
        }
        ans.append(root.val);
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }
}
