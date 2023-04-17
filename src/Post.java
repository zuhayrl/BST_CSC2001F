/*
 * Zuhayr Loonat
 * CSC2001F Assignment 4
 */
//package src;
import java.util.concurrent.ThreadLocalRandom;

public class Post{
    //class variables
    private String title;
    private String fileName;
    private int likes;

    //constructor
    public Post(String title, String fileName, int likes){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100000); 
        // gives random amount of likes coz im lazy :)

        this.title = title;
        this.fileName = fileName;
        // Set the number of likes to use for this user.
        if (likes==0){this.likes = randomNum;} 
        else   {this.likes = likes;}     
    }

    //getters
    /**
    * Returns the title of the post. Note that this is the not the file's name without the extension.
    * 
    * 
    * @return the title of the file as a string or null if not found or an error occurred ( such as the file doesn't exist
    */
    public String get_title(){return title;}
    /**
    * Returns the name of the file that was used to create this record.
    * 
    * 
    * @return the name of the file that was used to create this record or null if there is no file name
    */
    public String get_fileName(){return fileName;}
    /**
    * Returns the number of likes this item has. This is used to determine how many times the item has been liked
    */
    public int get_likes(){return likes;}
    
    /**
    * Returns a string representation of this object.
    * 
    * 
    * @return a string representation of this object in the form title file name likes and other information that can be printed
    */
    public String toString(){
        return( "--------------------------------------\n" +
                "Title: " + get_title() + "\n" +  
                "File Name: " + get_fileName() + "\n" + 
                "Likes: " + get_likes() + "\n" +
                "--------------------------------------");
    }


}
