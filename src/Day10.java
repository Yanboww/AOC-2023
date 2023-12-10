import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.io.File;
public class Day10 {
    public static void main(String[] args) {
        File f;
        try{
            f = new File("Trial");
            Scanner s = new Scanner(f);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}
