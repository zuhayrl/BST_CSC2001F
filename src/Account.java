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
    public String getUsername() {return username;}
    public String getUserDesc() {return userDesc;}
    public ArrayList<Post> getPosts() {return posts;} // not gnna use this its just here for consistancy

    //toString
    public String toString(){
        return("Username: " + getUsername() + "\n" + "User Description: " + getUserDesc() +
               "\n" + "User has: " + Integer.toString(posts.size()) + " posts." );
    }

    //display posts will return the posts formatted to look nice
    public void displayPosts(){
        //loop through the arraylist in reverse to get the posts from oldest to newest
        System.out.println( getUsername() +"'s Post");
        for (int i = posts.size()-1; i >= 0; i--) {
            System.out.println(posts.get(i));
        }
        System.out.println("\n");
    }

    //display account description
    public void displayDesc(){
        System.out.println("User Description: " + getUserDesc());
    }

    //add post
    public void addPost(String title, String fileName, int likes){
        Post post = new Post(title, fileName, likes);
        posts.add(post);

    }
    

}
