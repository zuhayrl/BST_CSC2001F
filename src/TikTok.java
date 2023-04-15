package src;

//imports
import java.util.Scanner;

public class TikTok {//start of program

    //1
    static void profile_desc(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the account name: ");
        String username = keyboard.next();

        /*
         * BST code goes here
         */
        
    }

    //2
    static void list_acc(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Accounts:");
        /*
         * BST code goes here
         */        
    }

    //3
    static void create_acc(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Create an Account");

        System.out.print("Enter username: ");
        String username = keyboard.next();

        System.out.print("Enter a user description: ");
        String desc = keyboard.next();

        Account account = new Account(username, desc);

        /*
         * BST code goes here
         */

        

    }

    //4
    static void delete_acc(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter user you would like to delete: ");
        String username = keyboard.next();

        /*
         * BST code goes here
         */
    }

    //5
    static void display_posts(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the account name: ");
        String username = keyboard.next();

        /*
         * BST code goes here
         */

         //display using displayPosts()
    }

    //6
    static void add_post(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the account name: ");
        String username = keyboard.next();

        System.out.println("Create a Post");

        System.out.print("Enter Title: ");
        String title = keyboard.next();

        System.out.print("Enter a post description: ");
        String desc = keyboard.next();

        Post post = new Post(title, desc);

        /*
         * BST code goes here
         */
    }

    //7
    static void load_action(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("7 laod_action");
    }

    //8
    static void exit_prog(){
        System.out.println("Exitted, have a nice day");
        System.exit(0);
    }

    //menu creation
    static void menu(){
        Scanner keyboard = new Scanner(System.in);
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

    public static void main(String[] args)  {//Main function starts here

        menu();

    }//void end


}//end of program 