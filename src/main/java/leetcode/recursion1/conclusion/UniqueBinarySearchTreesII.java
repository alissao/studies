package leetcode.recursion1.conclusion;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {



    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            List<TreeNode> trees = new ArrayList<>();
            return trees;
        }

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        
        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);

            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    // 'i' gets placed as the root of all subtrees generated from this stack frame
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left;
                    newNode.right = right;

                    trees.add(newNode);
                }
            }
        }
        return trees;
    }
}
