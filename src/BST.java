package src;
//import java.util.ArrayList;

public class BST{
    //creating node class (each node is an account)
    public class Node{
        //instance var
        private Account account;       
        public Node left, right;

        //constructor
        public Node(Account account){
            this.account = account;
        }

        //getters
        public String getUsername(){return account.getUsername();}
        public String getUserDesc(){return account.getUserDesc();}

        //toString
        public String toString(){return account.toString();}
    }

    //instance variables for BST
    public Node root;

    //constructor sets root to Null by default
    public BST(Node root) {
        this.root = null;
    }

    //inserts a new user
    public void insert(Account account){
        this.root = insert(root, account);
    }

    //node insert into tree
    public Node insert(Node node, Account account){
        //insert new data if node is null
        if (node == null){
            return new Node(account);
        }
        // create compare variable
        int iCompare = account.getUsername().compareTo(node.account.getUsername())


        //checking for > or <
        if (iCompare < 0){node.left = insert(node.left, account);}
        else if (iCompare > 0){node.right = insert(node.right, account);}
        
        return node;  
    }

    //Traversal
    public void preorder(){
        preorder(root);
        System.out.println();
    }

    public void preorder(Node root){
        if (root == null){return;}
        System.out.println(root.account.getUsername());
        preorder(root.left);
        preorder(root.right);
    }


}