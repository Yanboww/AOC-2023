import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
public class Day16 {
    public static void main(String[] args) {
        File f;
        try{
            f= new File("Trial");
            Scanner s = new Scanner(f);
            List<String> inputs = new ArrayList<>();
            List<String> coord = new ArrayList<>();
            List<String> map = new ArrayList<>();
            List<String> possible = new ArrayList<>();
            while(s.hasNextLine())
            {
                String next = s.nextLine();
                inputs.add(next);
                //moveList.add(next);
            }
            coord.add("0");
            coord.add("0");
            coord.add("right");
            move(inputs,coord,map,possible);
            //System.out.println(countTags(possible.get(possible.size()-1)));
            //System.out.println(possible.get(possible.size()-1));
            System.out.println(possible.size());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
        }
    }

    public static List<String> move(List<String> inputs, List<String> coord, List<String> map, List<String> possible)
    {
        //System.out.println(coord + "y");
        //System.out.println(move);
        //System.out.println("-----");
        if(map.contains(convertCoord(coord))) return possible;
        map.add(convertCoord(coord));
        if(!possible.contains(onlyCoord(coord)))possible.add(onlyCoord(coord));
        //System.out.println(possible);
        //System.out.println(coord);
        int row = Integer.parseInt(coord.get(0));
        int index = Integer.parseInt(coord.get(1));
        String direction = coord.get(2);
        coord.clear();
        String moveRow = inputs.get(row);
        /*if(index==moveRow.length()-1)
        {
            moveRow = moveRow.substring(0,index) + "#";
        }
        else if(index==0)
        {
            moveRow = "#" + moveRow.substring(1);
        }
        else{
            moveRow = moveRow.substring(0,index) + "#" + moveRow.substring(index+1);
        }**/
        //System.out.println(move);
        // System.out.println(moveRow+"  ----------");
        //move = replaceList(moveRow,move,row);
        //System.out.println(move);
        /*String list ="";
        for(String items: move)
        {
            list+=items+",";
        }**/
        //possible.add(list);
        //System.out.println(move);
        System.out.println(possible.size());
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

    public static List<String> replaceList(String replace, List<String> oldList,int index)
    {
        List<String> newList = new ArrayList<>();
        for(int i =0;i<oldList.size();i++)
        {
            if(i!=index)
            {
                newList.add(oldList.get(i));
            }
            else{
                newList.add(replace);
            }
        }
        return newList;
    }

    public static String convertCoord(List<String> coord)
    {
        return coord.get(0) + " " + coord.get(1)+" "+coord.get(2);
    }
    public static String onlyCoord(List<String> coord)
    {
        return coord.get(0) + " " + coord.get(1);
    }


    public static int countTags(String move)
    {
        int count = 0;
        for(int i = 0;i< move.length();i++)
        {
            String letter = move.substring(i,i+1);
            if(letter.equals(",")) count++;
        }
        return count;
    }



}
