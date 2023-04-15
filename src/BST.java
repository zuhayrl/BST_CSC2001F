package src;
//import java.util.ArrayList;



public class BST{
    //creating node class (each node is an account)
    public class Node{
        //instance var
        public Account account;       
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
    public BST() {
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
        int iCompare = account.getUsername().compareTo(node.getUsername());


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
    //print usernames.
    public void preorder(Node root){
        if (root == null){return;}
        System.out.println(root.account.getUsername());
        preorder(root.left);
        preorder(root.right);
    }
    //search to see if account exists
    public boolean search(String username){return search(this.root, username);}

    public boolean search(Node root, String username){
        if (root==null){return false;}

        int iCompare = username.compareTo(root.getUsername());
        if (root.getUsername() == username){return true;}
        else if (iCompare > 0){return search(root.right, username);}
        else {return search(root.left, username);}

    }


    //find and collect account data
    public Account find(String username){return find(this.root, username);}

    public Account find(Node root, String username){
        //no need for null check beacuse it was done in search()
        // this function only runs if search()=true
        //ie we know if the account exists already       
        int iCompare = username.compareTo(root.getUsername());

        if (iCompare > 0){return find(root.right, username);}
        else if (iCompare < 0){return find(root.left, username);}
        else return root.account;
    }

    //testing
    /*
    public static void main(String[] args){
        BST bst = new BST();
        Account a1 = new Account("1", "im 1");
        Account a2 = new Account("2", "im 2");
        Account a3 = new Account("3", "im 3");
        Account a4 = new Account("4", "im 4");
        Account a5 = new Account("5", "im 5");
        Account a6 = new Account("6", "im 6");
        bst.insert(a1);
        bst.insert(a4);
        bst.insert(a2);
        bst.insert(a6);
        bst.insert(a5);
        bst.insert(a3);

        bst.preorder();

        System.out.println(bst.search("7"));


    }
    */

}