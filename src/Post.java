/*
 * Zuhayr Loonat
 * CSC2001F Assignment 4
 */
package src;
import java.util.concurrent.ThreadLocalRandom;

public class Post{
    //class variables
    private String title;
    private String fileName;
    private int likes;

    //constructor
    public Post(String title, String fileName){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100000); 
        // gives random amount of likes coz im lazy

        this.title = title;
        this.fileName = fileName;
        this.likes = randomNum;        
    }

    //getters
    public String get_title(){return title;}
    public String get_fileName(){return fileName;}
    public int get_likes(){return likes;}
    
    public String toString(){
        return( "--------------------------------------\n" +
                "Title: " + get_title() + "\n" +  
                "File Name: " + get_fileName() + "\n" + 
                "Likes: " + get_likes() + "\n" +
                "--------------------------------------");
    }


}
