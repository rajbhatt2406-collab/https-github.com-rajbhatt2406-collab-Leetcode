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
    public int getMinimumDifference(TreeNode root) {
        ArrayList <Integer> list = new ArrayList<>();
        inOrder(root,list);
        Collections.sort(list);
         int n = list.size();
         int min = list.get(1) - list.get(0);
         for(int i=1; i<n-1; i++){
            if(list.get(i+1) - list.get(i) < min){
                min = list.get(i+1) - list.get(i);
            }
         }
         return min;
    }
    public void inOrder(TreeNode node , ArrayList <Integer> list ) {
    if (node == null) {
      return;
    }
   inOrder(node.left, list);
    list.add(node.val);
    inOrder(node.right,list);
  }

}