//will encounter stackoverflow if stack depth is not increased
//https://stackoverflow.com/questions/3700459/how-to-increase-the-java-stack-size
/*import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
public class Day16Part1 {
    public static void main(String[] args) {
        File f;
        try{
            f= new File("InputFile");
            Scanner s = new Scanner(f);
            List<String> inputs = new ArrayList<>();
            List<String> coord = new ArrayList<>();
            List<String> map = new ArrayList<>();
            List<String> possible = new ArrayList<>();
            while(s.hasNextLine())
            {
                String next = s.nextLine();
                inputs.add(next);
            }
            s.close();
            coord.add("0");
            coord.add("0");
            coord.add("right");
            move(inputs,coord,map,possible);
            System.out.println(possible.size());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
        }
    }

    public static List<String> move(List<String> inputs, List<String> coord, List<String> map, List<String> possible)
    {
        if(map.contains(convertCoord(coord))) return possible;
        map.add(convertCoord(coord));
        if(!possible.contains(onlyCoord(coord)))possible.add(onlyCoord(coord));
        int row = Integer.parseInt(coord.get(0));
        int index = Integer.parseInt(coord.get(1));
        String direction = coord.get(2);
        coord.clear();
        String moveRow = inputs.get(row);
        if(direction.equals("right"))
        {
            String next = inputs.get(row).substring(index,index+1);
            if(next.equals("|"))
            {
                if(row!=0)
                {
                    coord.add(Integer.toString(row-1));
                    coord.add(Integer.toString(index));
                    coord.add("up");
                    move(inputs,coord,map,possible);
                }
                if(row!=inputs.size()-1)
                {
                    List<String> coord2 = new ArrayList<>();
                    coord2.add(Integer.toString(row+1));
                    coord2.add(Integer.toString(index));
                    coord2.add("down");
                    move(inputs,coord2,map,possible);
                }
            }
            else if(next.equals("\\"))
            {
                if(row!=inputs.size()-1)
                {
                    coord.add(Integer.toString(row+1));
                    coord.add(Integer.toString(index));
                    coord.add("down");
                    move(inputs,coord,map,possible);
                }
            }
            else if(next.equals("/"))
            {
                if(row!=0)
                {
                    coord.add(Integer.toString(row-1));
                    coord.add(Integer.toString(index));
                    coord.add("up");
                    move(inputs,coord,map,possible);
                }
            }
            else{
                if(index!=moveRow.length()-1)
                {
                    coord.add(Integer.toString(row));
                    coord.add(Integer.toString(index+1));
                    coord.add("right");
                    move(inputs,coord,map,possible);
                }
            }
        }
        else if(direction.equals("left"))
        {
            String next = inputs.get(row).substring(index,index+1);
            if(next.equals("|"))
            {
                if(row!=0)
                {
                    coord.add(Integer.toString(row-1));
                    coord.add(Integer.toString(index));
                    coord.add("up");
                    move(inputs,coord,map,possible);
                }
                if(row!=inputs.size()-1)
                {
                    List<String> coord2 = new ArrayList<>();
                    coord2.add(Integer.toString(row+1));
                    coord2.add(Integer.toString(index));
                    coord2.add("down");
                    move(inputs,coord2,map,possible);
                }
            }
            else if(next.equals("\\"))
            {
                if(row!=0)
                {
                    coord.add(Integer.toString(row-1));
                    coord.add(Integer.toString(index));
                    coord.add("up");
                    move(inputs,coord,map,possible);
                }
            }
            else if(next.equals("/"))
            {
                if(row!=inputs.size()-1)
                {
                    coord.add(Integer.toString(row+1));
                    coord.add(Integer.toString(index));
                    coord.add("down");
                    move(inputs,coord,map,possible);
                }
            }
            else{
               if(index!=0)
               {
                   coord.add(Integer.toString(row));
                   coord.add(Integer.toString(index-1));
                   coord.add("left");
                   move(inputs,coord,map,possible);
               }
            }
        }
        else if(direction.equals("up"))
        {
            String next = inputs.get(row).substring(index,index+1);
            if(next.equals("-"))
            {
                if(index!=0)
                {
                    coord.add(Integer.toString(row));
                    coord.add(Integer.toString(index-1));
                    coord.add("left");
                    move(inputs,coord,map,possible);
                }
                if(index!=moveRow.length()-1)
                {
                    List<String> coord2 = new ArrayList<>();
                    coord2.add(Integer.toString(row));
                    coord2.add(Integer.toString(index+1));
                    coord2.add("right");
                    move(inputs,coord2,map,possible);
                }
            }
            else if(next.equals("\\"))
            {
                if(index!=0)
                {
                    coord.add(Integer.toString(row));
                    coord.add(Integer.toString(index-1));
                    coord.add("left");
                    move(inputs,coord,map,possible);
                }
            }
            else if(next.equals("/"))
            {
                if(index!=moveRow.length()-1)
                {
                    coord.add(Integer.toString(row));
                    coord.add(Integer.toString(index+1));
                    coord.add("right");
                    move(inputs,coord,map,possible);
                }
            }
            else{
                if(row!=0)
                {
                    coord.add(Integer.toString(row-1));
                    coord.add(Integer.toString(index));
                    coord.add("up");
                    move(inputs,coord,map,possible);
                }
            }
        }
        else{
            String next = inputs.get(row).substring(index,index+1);
            if(next.equals("-"))
            {
                if(index!=0)
                {
                    coord.add(Integer.toString(row));
                    coord.add(Integer.toString(index-1));
                    coord.add("left");
                    move(inputs,coord,map,possible);
                }
                if(index!=moveRow.length()-1)
                {
                    List<String> coord2 = new ArrayList<>();
                    coord2.add(Integer.toString(row));
                    coord2.add(Integer.toString(index+1));
                    coord2.add("right");
                    move(inputs,coord2,map,possible);
                }
            }
            else if(next.equals("\\"))
            {
                if(index!=moveRow.length()-1)
                {
                    coord.add(Integer.toString(row));
                    coord.add(Integer.toString(index+1));
                    coord.add("right");
                    move(inputs,coord,map,possible);
                }
            }
            else if(next.equals("/"))
            { if(index!=0)
            {
                coord.add(Integer.toString(row));
                coord.add(Integer.toString(index-1));
                coord.add("left");
                move(inputs,coord,map,possible);
            }
            }
            else{
                if(row!=inputs.size()-1)
                {
                    coord.add(Integer.toString(row+1));
                    coord.add(Integer.toString(index));
                    coord.add("down");
                    move(inputs,coord,map,possible);
                }
            }
        }
        return possible;
    }

    public static String convertCoord(List<String> coord)
    {
        return coord.get(0) + " " + coord.get(1)+" "+coord.get(2);
    }
    public static String onlyCoord(List<String> coord)
    {
        return coord.get(0) + " " + coord.get(1);
    }


}**/
