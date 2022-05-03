package Cautruc;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {
    public Tree mRoot;

    public MyBinaryTree(){

    }
    public Tree insert(Tree root, int value){
        //th1:
        if(root==null){
            root= new Tree(value);
            return root;
        }else{
            Tree temp = root;
            while (true){
                if(value>temp.val){
                    if(temp.right==null){
                        temp.right=new Tree(value);
                        break;
                    }else{
                        temp=temp.right;
                    }
                }else{
                    if(temp.left==null){
                        temp.left=new Tree(value);
                        break;
                    }else{
                        temp=temp.left;
                    }
                }
            }
            return root;
        }
    }
    public Tree insetRoot(Tree root ,int value){
        if(root==null){
            return new Tree(value);
        }
        if(value< root.val){
            if(root.left==null){
                root.left=new Tree(value);
            }else {
                insetRoot(root.left, value);
            }
        }else{
            if(root.right==null){
                root.right=new Tree(value);
            }else {
                insetRoot(root.right,value);
            }
        }
        return root;
    }

    //tim nut trai cung cua 1 cay
    public Tree find(Tree root){
        if(root==null){
            return null;
        }
        Tree leftNode = root;
        while (leftNode!=null){
            leftNode=leftNode.left;
        }
        return leftNode;
    }

    public Tree delete(Tree root ,int key){
        if(root==null){
            return null;
        }
        if(key< root.val){
            root.left= delete(root.left,key);
        }else if(key> root.val){
            root.right= delete(root.right,key);
        }else { //root.val=key
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left != null && root.right==null) {
                return root.left;
            }else if(root.left==null && root.right!=null){
                return root.right;
            }
            //tim not trai cung cay con phai
            Tree leftMode = find(root.right);
            root.val=leftMode.val;
            root.right = delete(root.right,leftMode.val);

        }
        return root;
    }

    //tim nut
    public Tree findRoot(Tree root,int key){
        if(root==null){
            return null;
        }
        if(key<root.val){
            return findRoot(root.left,key);
        }else if(key> root.val){
            return findRoot(root.right,key);
        }else{
            return root;
        }
    }

    //duyet cay(trc ,sau ,giua)
    public static void duyettrc(Tree root){
        if(root==null)
            return;
        System.out.print(root.val+" ");

        duyettrc(root.left);
        duyettrc(root.right);
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> duyet(Tree root){
        if(root==null)
            return result;
        result.add(root.val);

        duyettrc(root.left);
        duyettrc(root.right);
        return result;
    }

    //do sau cua cay
    public  int max(TreeNode root){
        if(root==null){
            return 0;
        }
        int bentrai= max(root.left);
        int benphai= max(root.right);

        int result = Math.max(benphai,bentrai)+1;
        return result;
    }

    //kiem tra lá
    public boolean isLast(TreeNode node){
        return node.left==null && node.right==null;
    }
    //duyet
    public boolean duyetcay(TreeNode node ,int sum,int value){
        if(node==null){
            return false;
        }
        sum+= node.val;
        if(isLast(node)){
            return sum==value;
        }
        boolean kqbentrai=duyetcay(node.left,sum,value);
        boolean kqbenphai=duyetcay(node.right,sum,value);
        return kqbenphai || kqbentrai;
    }
    //đường đi cây
    public boolean hasSum(TreeNode root,int value){
        return duyetcay(root,0,value);
    }

}
