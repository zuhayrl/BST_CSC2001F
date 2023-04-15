/*
 * Zuhayr Loonat
 * CSC2001F Assignment 4
 */
package src;

//imports
import java.util.Scanner;

public class TikTok {//start of program
    //varibales to be used (global)
    static BST bst = new BST();
    static Scanner keyboard = new Scanner(System.in);

    //1
    static void profile_desc(){
        System.out.print("Enter the account name: ");
        String username = keyboard.next();

        //BST code
         //check if the account exists

        try {bst.find(username).displayDesc();}
        catch (Exception e){System.out.println("Sorry, this account does not exist.");}

        //display menu 
        System.out.println("\n");
        menu();
            
        
    }

    //2
    static void list_acc(){
        System.out.println("Accounts:");
        
        //bst code
        bst.preorder(); 
        System.out.println("\n");
        menu();       
    }

    //3
    static void create_acc(){
        System.out.println("Create an Account");

        System.out.print("Enter username: ");
        String username = keyboard.next();

        System.out.print("Enter a user description: ");
        keyboard.nextLine();
        String desc = keyboard.nextLine();

        Account account = new Account(username, desc);

        //BST Code
        if (username.isEmpty() || desc.isEmpty()){
            System.out.println("Invlaid input, account was not created");}
        else {
            bst.insert(account);
            System.out.println("Account added successfully");
        }

        System.out.println("\n");
        menu();
    }

    //4
    static void delete_acc(){
        System.out.print("Enter user you would like to delete: ");
        String username = keyboard.next();

        //BST code
        if (username.isEmpty()){
            System.out.println("Invlaid input, no account was deleted");}
        else {
            try{bst.delete(username);
            System.out.println("Account deleted successfully");}
            catch(Exception e){System.out.println("Sorry, this account does not exist.");}
        }

        System.out.println("\n");
        menu();
    }

    //5
    static void display_posts(){
        System.out.print("Enter the account name: ");
        String username = keyboard.next();

        //bst code
        //check if the account exists

        try{bst.find(username).displayPosts();}
        catch(Exception e) {System.out.println("Sorry, this account does not exist.");}

        //display menu
        System.out.println("\n"); 
        menu();

    }

    //6
    static void add_post(){

        System.out.println("Create a Post");

        System.out.print("Enter the account name: ");
        String username = keyboard.next();

        System.out.print("Enter Title: ");
        keyboard.nextLine();
        String title = keyboard.nextLine();

        System.out.print("Enter a post file name: ");
        //keyboard.next();
        String fileName = keyboard.nextLine();

        //BST code
        if (username.isEmpty() || title.isEmpty() || fileName.isEmpty()){
            System.out.println("Invlaid input, post was not uploaded");}
        else {
            //check if the account exists
            try {bst.find(username).addPost(title, fileName);}
            catch(Exception e) {System.out.println("Sorry, this account does not exist.");}
        }

        //display menu 
        System.out.println("\n");
        menu();

    }

    //7
    static void load_action(){
        System.out.println("7 load_action");

        System.out.println("\n");
        menu();
    }

    //8
    static void exit_prog(){
        System.out.println("Exited, have a nice day");
        System.exit(0);
    }

    //menu creation
    static void menu(){
        int choice;

        System.out.println("Choose an action from the menu:");

        System.out.println("1. Find the profile description for a given account");
        System.out.println("2. List all accounts");
        System.out.println("3. Create an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Display all posts for a single account");
        System.out.println("6. Add a new post for an account");
        System.out.println("7. Load a file of actions from disk and process ths");
        System.out.println("8. Quit");

        System.out.print("Enter your choice: ");
        try{
            choice = Integer.parseInt(keyboard.next());

            System.out.println("\n");

            switch (choice) {
                case 1: profile_desc();break;
                case 2: list_acc();break;
                case 3: create_acc();break;
                case 4: delete_acc();break;
                case 5: display_posts();break;
                case 6: add_post();break;
                case 7: load_action();break;
                case 8: exit_prog();break;
            }
        }
        catch(Exception e){System.out.println("Invalid choice please try again.\n");menu();}
    }

    public static void main(String[] args)  {//Main function starts here
        //initialise all necessary var and classes
        
        //start program functionality
        menu();

        //testing
        //String text = keyboard.next();
        //Account a1 = new Account(text, "im an idiot");
        //bst.insert(a1);
        //System.out.println(bst.search(text));
        

    }//void end


}//end of program 