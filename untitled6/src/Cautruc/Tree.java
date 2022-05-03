package Cautruc;


public class Tree {
    public int val;
    public Tree left;
    public Tree right;

    public Tree(int val){
        this.val=val;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
