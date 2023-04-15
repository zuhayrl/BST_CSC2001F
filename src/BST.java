package src;
//import java.util.ArrayList;

public class BST {
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

    

}