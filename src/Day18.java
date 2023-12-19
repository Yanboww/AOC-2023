import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
public class Day18 {
    public static void main(String[] args) {
        File f;
        try {
            f = new File("Trial");
            Scanner s = new Scanner(f);
            List<String> commands = new ArrayList<>();
            List<String> coord = new ArrayList<>();
            List<String> drawing = new ArrayList<>();
            List<String> calcArea = new ArrayList<>();
            while (s.hasNextLine()) {
                commands.add(s.nextLine());
            }
            coord.add("0");
            coord.add("0");
            coord.add("L");
            int surrounding =0;
            for(String items: commands)
            {
                String direction = items.substring(0,1);
                int repeat = Integer.parseInt(items.substring(2,3));
                surrounding+=repeat;
                move(direction,repeat,drawing,coord,calcArea);
            }
            calcArea.add("0,0");
            System.out.println(calcArea);
            System.out.println(countTotal(calcArea,surrounding));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
    public static void move(String direction, int repeat, List<String> drawing, List<String> coord, List<String> calcArea)
    {
        int currentRow = Integer.parseInt(coord.get(1));
        int currentIndex = Integer.parseInt(coord.get(0));
        //System.out.println(coord);
        coord.clear();
        calcArea.add(currentIndex +","+currentRow);
        if(direction.equals("U"))
        {
            coord.add(Integer.toString(currentIndex));
            coord.add(Integer.toString(currentRow+repeat));

        }
        else if(direction.equals("D"))
        {
            coord.add(Integer.toString(currentIndex));
            coord.add(Integer.toString(currentRow-repeat));
        }
        else if(direction.equals("R"))
        {
            coord.add(Integer.toString(currentIndex+repeat));
            coord.add(Integer.toString(currentRow));
        }
        else{
            coord.add(Integer.toString(currentIndex-repeat));
            coord.add(Integer.toString(currentRow));
        }
    }

    public static int countTotal(List<String> calcArea,int outside)
    {
        int total;
        int total1 =0;
        int total2=0;
        for(int i =0;i<calcArea.size()-1;i++)
        {
            String line = calcArea.get(i);
            String line2 = calcArea.get(i+1);
            int x1 = Integer.parseInt(line.substring(0, line.indexOf(",")));
            int y1 = Integer.parseInt(line.substring(line.indexOf(",")+1));
            int x2 = Integer.parseInt(line2.substring(0,line2.indexOf(",")));
            int y2 = Integer.parseInt(line2.substring(line2.indexOf(",")+1));
            total1 += x1*y2;
            total2 += y1*x2;
        }
        total = (Math.abs(total1-total2))/2;
        total = total - (outside/2)+1 + outside;
        return total;

    }


}
