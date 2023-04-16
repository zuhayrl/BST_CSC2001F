/*
 * Zuhayr Loonat
 * CSC2001F Assignment 4
 */

package src;
import java.util.ArrayList;


public class Account {
    
    private String username;
    private String userDesc;
    public ArrayList<Post> posts  = new ArrayList<Post>();
    
    //constructor
    public Account(String username, String userDesc){
        this.username = username;
        this.userDesc = userDesc;
    }

    //getters
    /**
    * Returns the username associated with this user.
    * 
    * 
    * @return the username associated with this user or null if there is no username associated with this user or if the username is
    */
    public String getUsername() {return username;}
    /**
    * Returns the user description. 
    * 
    * 
    * @return the user description or null if there is no user description to
    */
    public String getUserDesc() {return userDesc;}
    /**
    * Returns the list of posts in the post list. This is a copy of the array returned by getPosts in Posts.java
    */
    public ArrayList<Post> getPosts() {return posts;} // not gnna use this its just here for consistancy

    //toString
    /**
    * Returns a string representation of this User. This is useful for debugging purposes. If you want to see the results of this method be sure to call #toString () on the returned string.
    * 
    * 
    * @return a string representation of this User's information ( username user description user has and number of posts )
    */
    public String toString(){
        return("Username: " + getUsername() + "\n" + "User Description: " + getUserDesc() +
               "\n" + "User has: " + Integer.toString(posts.size()) + " posts." );
    }

    //display posts will return the posts formatted to look nice
    /**
    * Displays the posts in reverse chronological order of newest to oldesr. 
    */
    public void displayPosts(){
        //loop through the arraylist in reverse to get the posts from oldest to newest
        System.out.println( getUsername() +"'s Post");
        // Prints the current list of posts.
        for (int i = posts.size()-1; i >= 0; i--) {
            System.out.println(posts.get(i));
        }
        System.out.println("\n");
    }

    //display account description
    /**
    * Displays the description of the user.
    */
    public void displayDesc(){
        System.out.println("User Description: " + getUserDesc());
    }

    //add post
    /**
    * Adds a post to the list of posts. This is a convenience method for calling #addPost ( Post )
    * 
    * @param title - The title of the post
    * @param fileName - The file name of the post 
    * @param likes - The number of likes ( 0< )
    */
    public void addPost(String title, String fileName, int likes){
        Post post = new Post(title, fileName, likes);
        posts.add(post);

    }
    

}
