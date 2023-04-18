package testing;

//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class testing {

    static boolean isBlank(String string){
        if (string == null || string.isEmpty()) {return true;}

        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);

            if (c != ' ' && c != '\t'){return false;}
        }

        return true;
    }


    static void load_action(){
        System.out.println("Load from textfile");

        String textFile = "datasettest.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(textFile))){
            String line;

            while ((line=br.readLine()) != null) {
                String type = line.substring(0, line.indexOf(" "));

                //create account
                if (type.equals("Create")){

                    String data = line.substring(line.indexOf(" ")+1);
                    String username = data.substring(0, data.indexOf(" "));
                    String desc = data.substring(data.indexOf(" ")+1);

                    System.out.println("Username:"+username);
                    System.out.println("Description:"+desc);

                    //insert to bst
                }
                //add post to account
                if (type.equals("Add")){
                    
                    String data = line.substring(line.indexOf(" ")+1);
                    String username = data.substring(0, data.indexOf(" "));
                    data = data.substring(data.indexOf(" ")+1);
                    String fileName = data.substring(0, data.indexOf(" "));
                    data = data.substring(data.indexOf(" ")+1);
                    String likes = data.substring(0, data.indexOf(" "));
                    String title = data.substring(data.indexOf(" ")+1);

                    System.out.println("Username:"+username);
                    System.out.println("File Name:"+fileName);
                    System.out.println("Likes:"+likes);
                    System.out.println("title:"+title);
                }

            }
            System.out.println("File was read successfully");
            

        }
        catch(Exception e){
            System.out.println("File could not be read");
        }

        
        System.out.println("\n");
        
    }

    public static void main(String[] args){
        //load_action();
        String  str = "";
        System.out.println(isBlank(str));
        str = "\t";
        System.out.println(isBlank(str));
        str = "   ";
        System.out.println(isBlank(str));
        str = "4";
        System.out.println(isBlank(str));
        

        

    }
    
}
