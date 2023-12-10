//took a long time to run idk I just left it running and watched YouTube
/*import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
public class Day5 {
    public static void main(String[] args) {
        File f;
        try{
            f = new File("InputFile");
            Scanner s = new Scanner(f);
            int count =0;
            List<String> seed = new ArrayList<>();
            List<String> soil = new ArrayList<>();
            List<String> fert = new ArrayList<>();
            List<String> water = new ArrayList<>();
            List<String> light = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            List<String> hum = new ArrayList<>();
            List<String> location = new ArrayList<>();
            List<Double> endLocation = new ArrayList<>();
            while(s.hasNextLine())
            {
                String line = s.nextLine();
                if(!checkInt(line))
                {
                    count+=1;
                    line = s.nextLine();
                }
                if(count == 1)
                {
                    seed.add(line);
                }
                else if(count == 2)
                {
                    soil.add(line);
                }
                else if(count == 3)
                {
                    fert.add(line);
                }
                else if(count == 4)
                {
                    water.add(line);
                }
                else if(count == 5)
                {
                    light.add(line);
                }
                else if(count == 6)
                {
                    temp.add(line);
                }
                else if(count == 7)
                {
                    hum.add(line);
                }
                else{
                    location.add(line);
                }
            }
            //part 1
            /*String seeds = seed.get(0)+" ";
            seed.clear();
            String num="";
            for(int c =0;c<seeds.length();c++)
            {
                String seedLetter = seeds.substring(c,c+1);
                if(!seedLetter.equals(" "))
                {
                    num+=seedLetter;
                }
                else{
                    seed.add(num);
                    num="";
                }
            }**/

            //part 2
            /*seed = validSeeds(seed);
            System.out.println(seed.size());
            while(!seed.isEmpty())
            {
                String items = seed.get(0);
                seed.remove(0);
                String toSoil = findNext(soil,items);
                String toFert = findNext(fert,toSoil);
                String toWater = findNext(water,toFert);
                String toLight = findNext(light,toWater);
                String toTemp = findNext(temp,toLight);
                String toHum = findNext(hum,toTemp);
                String toLocation = findNext(location,toHum);
                endLocation.add(Double.parseDouble(toLocation));
                System.out.println(endLocation.size());
            }
            //System.out.println(endLocation);
            System.out.printf("lowest: %f\n", calculateMin(endLocation));

        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not Found");
        }
    }
    public static boolean checkInt(String line)
    {
        try{
            int l = 0;
            for(int a = 0;a<line.length();a++)
            {
                String letter = line.substring(a,a+1);
                if(!letter.equals(" ")){
                    l+=Integer.parseInt(letter);
                }
            }
            return true;
        }
        catch(NumberFormatException a)
        {
            return false;
        }
    }

    public static String findNext(List<String> startMatch, String start)
    {
        List<String> match = new ArrayList<>();
        List<String> endMatch = new ArrayList<>();
        for(String item: startMatch)
        {
            double repeat = Double.parseDouble(item.substring(item.lastIndexOf(" ")+1));
            double destination = Double.parseDouble(item.substring(0, item.indexOf(" ")));
            double starts =  Double.parseDouble(item.substring(item.indexOf(" ")+1,item.lastIndexOf(" ")));
            match.add(Double.toString(starts));
            endMatch.add(Double.toString(destination));
            if(Double.parseDouble(start)<=starts+repeat-1 && Double.parseDouble(start)>starts)
            {
                double diff = Double.parseDouble(start)-starts;
                match.add(start);
                double end = destination+diff;
                endMatch.add(Double.toString(end));

            }
        }
        int index = match.indexOf(start);
        if(index==-1)
        {
            return start;
        }
        return endMatch.get(index);
    }

    public static double calculateMin(List<Double> end)
    {
        double low = end.get(0);
        for(Double item : end)
        {
            if(low>item)
            {
                low =item;
            }
        }
        return low;
    }

    public static List<String> validSeeds(List<String> seed)
    {
        List<String> valid = new ArrayList<>();
        String seeds = seed.get(0)+" ";
        seed.clear();
        String num="";
        int count = 1;
        double current = 0;
        for(int c =0;c<seeds.length();c++)
        {
            String seedLetter = seeds.substring(c,c+1);
            if(!seedLetter.equals(" ") || count <2)
            {
                if(seedLetter.equals(" "))
                {
                    count++;
                    current = Integer.parseInt(num);
                }
                num+=seedLetter;
            }
            else{
                double last = current-1+Double.parseDouble(num.substring(num.indexOf(" ")+1));
                //System.out.println(last);
                for(double z = current;z<=last;z++)
                {
                    String value = Double.toString(z);
                    if(!valid.contains(value))
                    {
                        valid.add(value);
                        //System.out.println(valid.size());

                    }
                }
                num="";
                count=1;
                current = 0;
                //System.out.println(valid);
            }
        }
        return valid;
    }


}**/