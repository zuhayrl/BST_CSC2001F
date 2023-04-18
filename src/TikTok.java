/*
 * Zuhayr Loonat
 * CSC2001F Assignment 4
 */
//package src;


//imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class TikTok {//start of program
    //varibales to be used (global)
    static BST bst = new BST();
    static Scanner keyboard = new Scanner(System.in);

    //1
    /**
    * Get account description and display it in BST. This is a menu that allows you to select an
    * and get a description
    */
    public static void profile_desc(){
        System.out.println("Get account description");
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
    /**
    * Lists account in BST. This is a recursive function
    */
    public static void list_acc(){
        System.out.println("List Accounts");
        System.out.println("Accounts:");
        
        //bst code
        bst.preorder(); 
        System.out.println("\n");
        menu();       
    }

    //3
    /**
    * Create an Account from user input and insert it into BST.
    */
    public static void create_acc(){
        System.out.println("Create an Account");

        System.out.print("Enter username: ");
        String username = keyboard.next();

        System.out.print("Enter a user description: ");
        keyboard.nextLine();
        String desc = keyboard.nextLine();

        Account account = new Account(username, desc);

        //BST Code
        // Insert account into the database.
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
    /**
    * Delete an account from BST and display success or failure message to the user. This is a shortcut for the delete method
    */
    public static void delete_acc(){
        System.out.println("Delete an Account");
        System.out.print("Enter user you would like to delete: ");
        String username = keyboard.next();

        //BST code
        // Delete the account with the given username.
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
    /**
    * Display User's Posts, Enter the account name, Check if account exists, Display the posts if it does
    */
    public static void display_posts(){
        System.out.println("Display User's Posts");
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
    /**
    * Adds a post to an account in the BST.This method requires the user to enter the account name
    */
    public static void add_post(){

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
        // check input validity
        if (username.isEmpty() || title.isEmpty() || fileName.isEmpty()){
            System.out.println("Invlaid input, post was not uploaded");}
        else {
            //check if the account exists
            try {bst.find(username).addPost(title, fileName, 0);}
            catch(Exception e) {System.out.println("Sorry, this account does not exist.");}
        }

        //display menu 
        System.out.println("\n");
        menu();

    }

    //7
    /**
    * Load from text file that has lines that tell the app to either create an account or add a post to an acount
    */
    public static void load_action(){
        System.out.println("Load from text file");
        //find textfile
        //String textFile = "C:\\Users\\zuhay\\OneDrive\\My Documents\\Git\\Github\\BST_CSC2001F\\src\\dataset.txt"; 
        String textFile = "*/dataset.txt";
      
        try (BufferedReader br = new BufferedReader(new FileReader(textFile))){
            String line;
            //read each line
            // This method reads the line from the input stream.
            while ((line=br.readLine()) != null) {
                String type = line.substring(0, line.indexOf(" "));

                //create account

                if (type.equals("Create")){
                    //use of string manipulation to choose certain parts of string
                    String data = line.substring(line.indexOf(" ")+1);
                    String username = data.substring(0, data.indexOf(" "));
                    String desc = data.substring(data.indexOf(" ")+1);

                    //System.out.println("Username:"+username);
                    //System.out.println("Description:"+desc);

                    //insert to bst
                    Account account = new Account(username, desc);
                    bst.insert(account);

                    //insert to bst
                }
                //add post to account
                if (type.equals("Add")){
                    //use of string manipulation to choose certain parts of string
                    String data = line.substring(line.indexOf(" ")+1);
                    String username = data.substring(0, data.indexOf(" "));
                    data = data.substring(data.indexOf(" ")+1);
                    String fileName = data.substring(0, data.indexOf(" "));
                    data = data.substring(data.indexOf(" ")+1);
                    String likes = data.substring(0, data.indexOf(" "));
                    String title = data.substring(data.indexOf(" ")+1);

                    //System.out.println("Username:"+username);
                    //System.out.println("File Name:"+fileName);
                    //System.out.println("Likes:"+likes);
                    //System.out.println("title:"+title); 

                    //insert to bst
                    try {bst.find(username).addPost(title, fileName, Integer.parseInt(likes));}
                    catch(Exception e) {}
                }

            }
            System.out.println("File was read successfully");
            

        }
        catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }


        System.out.println("\n");
        menu();
    }

    //8
    /**
    * Exit program and print message to standard output and exit with 0.
    */
    public static void exit_prog(){
        System.out.println("Exited, have a nice day");
        System.exit(0);
    }

    //menu creation
    /**
    * Menu for the user to choose an action from the menu and execute the appropriate function based on the choice
    */
    public static void menu(){
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

            // The choice of the action to be performed.
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

    /**
    * Main function starts here. Initialises all necessary variables and classes.
    * 
    * @param args - Command line arguments for
    */
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