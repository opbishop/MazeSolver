import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeReader {
    public Maze readMaze(File file){
        List<String> list = new ArrayList<>();

        try {
            //Scan input file line by line
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                list.add(input.nextLine());
            }
        }
        catch (java.io.FileNotFoundException e) {
            //Handle exception if file doesn't exist
            System.out.println("No such file found");
        }

        // Split pairs of ints to get start/end co-ordinates and matrix dimensions
        // This could be regex but left like this for simplicity
        int[] dimensions = split_string(list.get(0));
        list.remove(0);
        int[] start = split_string(list.get(0));
        list.remove(0);
        int[] finish = split_string(list.get(0));
        list.remove(0);

        char[][] map = new char[dimensions[1]][dimensions[0]];

        for (int i=0; i < map.length; i++) {
            // Draw maze map
            list.set(i, list.get(i).replaceAll("\\s+", ""));
            for (int j=0; j < list.get(i).length(); j++){
                map[i] = list.get(i).toCharArray();
            }
        }

        return new Maze(dimensions, start, finish, map);
    }

    private static int[] split_string(String str) {

        String[] split_strings = str.split("\\s+");
        int[] converted_strings = new int[split_strings.length];

        for (int i=0; i < split_strings.length; i++){
            converted_strings[i] = Integer.parseInt(split_strings[i]);
        }

        return converted_strings;
    }
}
