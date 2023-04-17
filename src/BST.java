/*
 * Zuhayr Loonat
 * CSC2001F Assignment 4
 */
//package src;
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
        /**
        * Returns the username associated with this user. This is a getter for the #account. username property.
        * 
        * 
        * @return the username associated with this user or null if there is no username associated with this user or if the account does not
        */
        public String getUsername(){return account.getUsername();}
        /**
        * Returns the user description.
        * 
        * 
        * @return the user description or null if there is no user description in the user's account
        */
        public String getUserDesc(){return account.getUserDesc();}

        //toString
        /**
        * Returns a string representation of this account. This is useful for debugging purposes. If you want to see the account in a human readable format use #toString ()
        * 
        * 
        * @return a string representation of this
        */
        public String toString(){return account.toString();}
    }

    //instance variables for BST
    public Node root;

    //constructor sets root to Null by default
    public BST() {
        this.root = null;
    }

    //inserts a new user
    /**
    * Inserts an account into the tree.
    * 
    * @param account - the account to be inserted into the tree ; may not be
    */
    public void insert(Account account){
        this.root = insert(root, account);
    }

    //node insert into tree
    /**
    * Inserts data into the tree. This method is used to insert data into the tree by traversing the tree from root to leaf until it finds the node with the same username.
    * 
    * @param node - the node to start from may be null in which case a new node is created
    * @param account - the account to insert must not be null and must be a member of Account
    * 
    * @return the node with the inserted data never null but may be the same as the node passed in if it was
    */
    private Node insert(Node node, Account account){
        //insert new data if node is null
        // Returns the node for this account.
        if (node == null){
            return new Node(account);
        }
        // create compare variable
        int iCompare = account.getUsername().compareTo(node.getUsername());


        //checking for > or <
        // inserts the left node in tree
        if (iCompare < 0){node.left = insert(node.left, account);}
        // inserts the right node in the tree
        else if (iCompare > 0){node.right = insert(node.right, account);}
        
        return node;  
    }

    //Traversal
    /**
    * Prints the pre - order traversal of the tree starting from the root node. Note that this is a depth first traversal
    */
    public void preorder(){
        preorder(root);
        System.out.println();
    }
    //print usernames.
    /**
    * Prints the left and right subtrees of the root node in preorder. Note that this does not traverse the tree rooted at the root.
    * 
    * @param root - the root of the tree to be printed in
    */
    private void preorder(Node root){
        
        if (root == null){return;}
        System.out.println(root.getUsername());
        preorder(root.left);
        preorder(root.right);
    }
    //search to see if account exists
    /* 
    public boolean search(String username){return search(this.root, username);}

    private boolean search(Node root, String username){
        if (root==null){return false;}

        int iCompare = username.compareTo(root.getUsername());
        if (root.getUsername() == username){return true;}
        else if (iCompare > 0){return search(root.right, username);}
        else {return search(root.left, username);}

    }
    */


    //find and collect account data
    /**
    * Finds an account by username. 
    * 
    * @param username - the username to look for
    * 
    * @return the account or null if not found 
    */
    public Account find(String username){return find(this.root, username);}

    /**
    * Finds an account in the tree.
    * 
    * @param root - the root of the tree
    * @param username - the username to search for in the tree.
    * 
    * @return the account or null if not found ( in which case the account is not found ). Note that this function does not check if the account exists
    */
    private Account find(Node root, String username){
        //no need for null check beacuse it was done in search()
        // this function only runs if search()=true
        //ie we know if the account exists already       
        int iCompare = username.compareTo(root.getUsername());

        // Returns the user s account or null if no such user exists.
        if (iCompare > 0){return find(root.right, username);}
        // Returns the account of the user from the tree.
        else if (iCompare < 0){return find(root.left, username);}
        else return root.account;
    }

    //delete a node
    /**
    * Delete a user from the user tree.
    * 
    * @param username - The username of the user to delete from the user
    */
    public void delete(String username){root = delete(root, username);}

    /**
    * Deletes the node with the given username from the tree. This method is recursive in that it traverses the tree to find the node with the given username and deletes it from the tree.
    * 
    * @param root - the root of the tree to be deleted.
    * @param username - the username of the node to be deleted.
    * 
    * @return the node with the given username that was deleted from the tree ; this is the root of the deleted subtree
    */
    private Node delete(Node root, String username){
        // Returns the root node of the tree.
        if (root==null){return root;}
        //compare values
        int iCompare = username.compareTo(root.getUsername());
        //recur down
        // Delete the node on the left.
        if (iCompare < 0){root.left = delete(root.left, username);}
        // Delete the node on the right
        else if (iCompare > 0){root.right = delete(root.right, username);}
        //we are at the point of deletion node
        else {
            //node with one or no child
            // Returns the rightmost node in the tree.
            if (root.left==null){return root.right;}
            // Returns the leftmost node in the tree.
            else if (root.right==null){return root.left;}

            root.account = minValue(root.right);
            root.right = delete(root.right, root.getUsername());

        }
        return root;
    }

    /**
    * Finds the minimum value in a BST. This is used to determine the account that is most recently added in the tree
    * 
    * @param root - the root of the tree
    * 
    * @return the minimum value in the tree or null if the tree is empty or has no minimum value
    */
    private Account minValue(Node root){
        Account minv = root.account;
        // Find the minimum account of the root node.
        while (root.left != null){
            minv = root.left.account;
            root = root.left;
        }
        return minv;
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
        String username = "6" ;
        boolean exists = bst.search(username);
        if(exists){bst.find(username).displayDesc();}
        else{System.out.println("DNE");}


    }
    */
    

}