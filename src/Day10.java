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
            String cornerKey ="FJ7LS";
            while(s.hasNextLine())
            {
                maze.add(s.nextLine());
            }
            int start = findStart(maze);
            List<String> visited = new ArrayList<>();
            List<String> visited1 = new ArrayList<>();
            visited.add(Integer.toString(start)+","+ Integer.toString(maze.get(start).indexOf("S")));
            List<String> direction1 = moveInitial(maze,start,"right");
            List<String> direction2 = moveInitial(maze,start,"down");
            List<String> direction3 = moveInitial(maze,start,"left");
            List<String> direction4 = moveInitial(maze, start, "up");
            int count =1;
            String compare1 = direction2.get(0) + direction2.get(1);
            String compare2 = direction1.get(0) +  direction1.get(1);
            if(cornerKey.contains(direction1.get(3)))visited.add(direction1.get(0) +"," + direction1.get(1));
            else visited1.add(direction1.get(0) +"," + direction1.get(1));
            if(cornerKey.contains((direction2.get(3))))visited.add(direction2.get(0) +"," + direction2.get(1));
            else visited1.add(direction2.get(0) +"," + direction2.get(1));
            while(!compare1.equals(compare2))
            {
                count++;
                move(maze,direction1);
                move(maze,direction2);
                compare1 = direction2.get(0) + direction2.get(1);
                compare2 = direction1.get(0) +  direction1.get(1);
                if(cornerKey.contains(direction1.get(3)))visited.add(direction1.get(0) +"," + direction1.get(1));
                else visited1.add(direction1.get(0) +"," + direction1.get(1));
                if(cornerKey.contains((direction2.get(3))))visited.add(direction2.get(0) +"," + direction2.get(1));
                else visited1.add(direction2.get(0) +"," + direction2.get(1));
            }
            move(maze,direction1);
            move(maze,direction2);
            if(cornerKey.contains(direction1.get(3)))visited.add(direction1.get(0) +"," + direction1.get(1));
            else visited1.add(direction1.get(0) +"," + direction1.get(1));
            if(cornerKey.contains((direction2.get(3))))visited.add(direction2.get(0) +"," + direction2.get(1));
            else visited1.add(direction2.get(0) +"," + direction2.get(1));
            System.out.println(count+1);

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

    public static List<String> moveInitial(List<String> maze, int start,String direction)
    {
        List<String> next = new ArrayList<>();
        String line = maze.get(start);
        int startIndex = line.indexOf("S");
        String letter = "";
        if(direction.equals("right")&&startIndex!=line.length()-1) {
            letter = line.substring(startIndex + 1, startIndex + 2);
            if(letter.equals("J"))
            {
                next.add(Integer.toString(start-1));
                next.add(Integer.toString(startIndex+1));
                next.add("up");
            }
            else if(letter.equals("7"))
            {
                next.add(Integer.toString(start+1));
                next.add(Integer.toString(startIndex+1));
                next.add("down");
            }
            else if(letter.equals("-"))
            {
                next.add(Integer.toString(start));
                next.add(Integer.toString(startIndex+2));
                next.add("right");
            }
            next.add(letter);
        }
        else if(direction.equals("left")&&startIndex!=0){
            letter = line.substring(startIndex-1,startIndex);
            if(letter.equals("F"))
            {
                next.add(Integer.toString(start+1));
                next.add(Integer.toString(startIndex-1));
                next.add("down");
            }
            else if(letter.equals("-"))
            {
                next.add(Integer.toString(start));
                next.add(Integer.toString(startIndex-2));
                next.add("left");
            }
            else if(letter.equals("L"))
            {
                next.add(Integer.toString(start-1));
                next.add(Integer.toString(startIndex-1));
                next.add("up");
            }
            next.add(letter);
        }
        else if(direction.equals("up")){
            letter = maze.get(start-1).substring(startIndex,startIndex+1);
            if(letter.equals("F"))
            {
                next.add(Integer.toString(start-1));
                next.add(Integer.toString(startIndex+1));
                next.add("right");
            }
            else if(letter.equals("|"))
            {
                next.add(Integer.toString(start-2));
                next.add(Integer.toString(startIndex));
                next.add("up");
            }
            else if(letter.equals("7"))
            {
                next.add(Integer.toString(start-1));
                next.add(Integer.toString(startIndex-1));
                next.add("left");
            }
            next.add(letter);
        }
        else {
            letter = maze.get(start + 1).substring(startIndex, startIndex + 1);
            if(letter.equals("J"))
            {
                next.add(Integer.toString(start+1));
                next.add(Integer.toString(startIndex-1));
                next.add("left");
            }
            else if(letter.equals("|"))
            {
                next.add(Integer.toString(start+2));
                next.add(Integer.toString(startIndex));
                next.add("down");
            }
            else if(letter.equals("L"))
            {
                next.add(Integer.toString(start+1));
                next.add(Integer.toString(startIndex+1));
                next.add("right");
            }
            next.add(letter);
        }
        return next;
    }

    public static List<String> move(List<String> maze, List<String> coord)
    {
        int row = Integer.parseInt(coord.get(0));
        int index = Integer.parseInt(coord.get(1));
        String direction = coord.get(2);
        coord.clear();
        String current = maze.get(row).substring(index,index+1);
        if(current.equals("|") && direction.equals("up"))
        {
            coord.add(Integer.toString(row-1));
            coord.add(Integer.toString(index));
            coord.add("up");
            coord.add(current);
        }
        else if(current.equals("F") &&  direction.equals("up"))
        {
            coord.add(Integer.toString(row));
            coord.add(Integer.toString(index+1));
            coord.add("right");
            coord.add(current);
        }
        else if(current.equals("7") &&  direction.equals("up"))
        {
            coord.add(Integer.toString(row));
            coord.add(Integer.toString(index-1));
            coord.add("left");
            coord.add(current);
        }
        else if(current.equals("-") &&  direction.equals("right"))
        {
            coord.add(Integer.toString(row));
            coord.add(Integer.toString(index+1));
            coord.add("right");
            coord.add(current);
        }
        else if(current.equals("-") &&  direction.equals("left"))
        {
            coord.add(Integer.toString(row));
            coord.add(Integer.toString(index-1));
            coord.add("left");
            coord.add(current);
        }
        else if(current.equals("J") && direction.equals("right"))
        {
            coord.add(Integer.toString(row-1));
            coord.add(Integer.toString(index));
            coord.add("up");
            coord.add(current);
        }
        else if(current.equals("7") && direction.equals("right"))
        {
            coord.add(Integer.toString(row+1));
            coord.add(Integer.toString(index));
            coord.add("down");
            coord.add(current);
        }
        else if(current.equals("L") && direction.equals("left"))
        {
            coord.add(Integer.toString(row-1));
            coord.add(Integer.toString(index));
            coord.add("up");
            coord.add(current);
        }
        else if(current.equals("F") && direction.equals("left"))
        {
            coord.add(Integer.toString(row+1));
            coord.add(Integer.toString(index));
            coord.add("down");
            coord.add(current);
        }
        else if(current.equals("|") && direction.equals("down"))
        {
            coord.add(Integer.toString(row+1));
            coord.add(Integer.toString(index));
            coord.add("down");
            coord.add(current);
        }
        else if(current.equals("L") && direction.equals("down"))
        {
            coord.add(Integer.toString(row));
            coord.add(Integer.toString(index+1));
            coord.add("right");
            coord.add(current);
        }
        else if(current.equals("J") && direction.equals("down"))
        {
            coord.add(Integer.toString(row));
            coord.add(Integer.toString(index-1));
            coord.add("left");
            coord.add(current);
        }
        return coord;
    }

   /* public static int intersection(List<String> maze, List<String> border, List<String> side)
    {
        int within =0;
        for(int a =0;a<maze.size();a++)
        {
            String items = maze.get(a);
            for(int i =0;i<items.length();i++)
            {
                String coord = a + ","+i;
                if(!border.contains(coord) && !side.contains(coord))
                {

                }
            }
        }
        return within;
    }**/




}
