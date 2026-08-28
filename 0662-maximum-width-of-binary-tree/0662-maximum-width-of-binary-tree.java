/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> arr = levelOrder(root);

        if (arr.isEmpty()) {
            return 0;
        }

        return Collections.max(arr);
    }

    public List<Integer> levelOrder(TreeNode root) {

        List<Integer> width = new ArrayList<>();

        if (root == null) {
            return width;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();

        queue.offer(root);
        indexQueue.offer(0);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            int firstIndex = 0;
            int lastIndex = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();
                int index = indexQueue.poll();

                if (i == 0) {
                    firstIndex = index;
                }

                if (i == levelSize - 1) {
                    lastIndex = index;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    indexQueue.offer(2 * index);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    indexQueue.offer(2 * index + 1);
                }
            }

            int wid = lastIndex - firstIndex + 1;
            width.add(wid);
        }

        return width;
    }
}