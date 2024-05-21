// java File Handling

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Exception;
import java.util.Scanner;
// methods contain in the File class
// canRead()
// canWrite()
// createNewFile()
// delete()
// exists()
// getName()
// getAbsolutePath()
// length()
// list()
// makedir()

// public class File_Handling{
//     public static void main(String[] args){
//         try{
//          File myFile = new File("newjavaclass.txt");
//             if(myFile.createNewFile()){
//                 System.out.println("File vreated successfully" + myFile.getName());
//             }
//             else{
//                 System.out.println("File already exists");
//             }
//         }
//         catch(IOException eo){
//             System.out.println("An error prevented the file to be created");
//             eo.printStackTrace();
//         }
//     }
// }

// public class File_Handling{
//     public static void main(String[] args){
//         try{
//         FileWriter myFile = new FileWriter("newjavaclass.txt");
//         String content ="This is a java class. the topic today is a java file handling. now we are to write to a file after we have create the file";
//         myFile.write(content);
//         myFile.close();
//         System.out.println("content written to file successfully");

//         }
//         catch(IOException eo){
//             System.out.println("An error prevented the file to be created");
//             eo.printStackTrace();
//         }
//     }
// }

public class File_Handling{
    public static void main(String[] args){
        try{
        File myFile = new File("newjavaclass.txt");
        // Scanner scan = new Scanner(myFile);
        // // while(scan.hasNextLine()){
        // //     String content =scan.nextLine();
        // //     System.out.println(content);
        // // }
        if(myFile.exists()){

            System.out.println("If file is exist");
            System.out.println("File name is" + myFile.getName());
            System.out.println("get full path of the " + myFile.getAbsolutePath());
            System.out.println("Check if file is writeable" + myFile.canWrite());
            System.out.println("Check if file is readable" + myFile.canRead());
            System.out.println("The length of the file is" + myFile.length());
            System.out.println("Delete the file from my PC" + myFile.delete());
        }
        else{
            System.out.println("File dose not exist but we will create it");
            try{
        //  File myFile = new File("newjavaclass.txt");
            if(myFile.createNewFile()){
                System.out.println("File Created successfully" + myFile.getName());
            }
            
        }
        catch(IOException eo){
            System.out.println("An error prevented the file to be created");
            eo.printStackTrace();
        }
        }
        // scan.close();
        }
        catch(Exception e){
            System.out.println("An error prevented the file from being open");
            e.printStackTrace();
}
}
}
