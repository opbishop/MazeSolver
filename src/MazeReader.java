import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeReader {
    public Maze readMaze(File file){
//        File file = new File("mazes/medium_input.txt");
        List<String> list = new ArrayList<String>();

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                list.add(input.nextLine());
            }
        }
        catch (java.io.FileNotFoundException e) {
            System.out.println("No such file found");
        }

        int[] dimensions = split_string(list.get(0));
        list.remove(0);
        int[] start = split_string(list.get(0));
        list.remove(0);
        int[] finish = split_string(list.get(0));
        list.remove(0);

        char[][] map = new char[dimensions[1]][dimensions[0]];

        for (int i=0; i < map.length; i++) {
            list.set(i, list.get(i).replaceAll("\\s+", ""));
            for (int j=0; j < list.get(i).length(); j++){
                map[i] = list.get(i).toCharArray();
            }
        }

        Maze maze = new Maze(dimensions, start, finish, map);

        return maze;
    }

    public static int[] split_string(String str) {

        String[] split_strings = str.split("\\s+");
        int[] converted_strings = new int[split_strings.length];

        for (int i=0; i < split_strings.length; i++){
            converted_strings[i] = Integer.parseInt(split_strings[i]);
        }

        return converted_strings;
    }


}
