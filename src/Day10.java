import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
public class Day10 {
    public static void main(String[] args) {
        File f;
        try{
            f = new File("Trial");
            Scanner s = new Scanner(f);
            List<String> maze = new ArrayList<>();
            while(s.hasNextLine())
            {
                maze.add(s.nextLine());
            }
            int start = findStart(maze);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
    public static int findStart(List<String> maze)
    {
        int count = 0;
        for(String items: maze)
        {
            if(items.contains("S"))
            {
                break;
            }
            count++;
        }
        return count;
    }
    public static void moveRight(List<String> maze,int start)
    {
        String moveKey = "F7J|-L";
        String firstMoveKey ="J-";
        String startLine = maze.get(start);
        int index = startLine.indexOf("S");
        String next = startLine.substring(index+1,index+2);
        String prev =next;
        if(firstMoveKey.contains(next))
        {
           while(moveKey.contains(next))
           {
               if(next.equals("J"))
               {
                   next = (maze.get(start+1)).substring(index+1,index+2);
                   start++;
                   index++;

               }
               else if(next.equals("-"))
               {
                   if(prev.equals("F") || prev.equals("L"))
                   {
                       next = (maze.get(start)).substring(index+1,index+2);
                       index++;
                   }
                   else if(prev.equals("7"))
                   {
                       next = (maze.get(start)).substring(index-2,index-1);
                       index--;
                   }
               }
               else if(next.equals("F"))
               {
                   next = (maze.get(start+1)).substring(index+1,index+2);
                   start++;
                   index++;
               }
               prev = next;
           }
        }
    }


}
