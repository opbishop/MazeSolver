import java.io.File;

public class Main {
    public static void main(String args[]) {
        MazeReader mazeReader = new MazeReader();

        // current directory
        File folder = new File("./mazes");
        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles){
            System.out.println("Maze file " + file.getName() + ":");
            Maze maze = mazeReader.readMaze(file);
            if(maze.solve(maze.getStart())) {
                maze.showMap();
            } else {
                System.out.println("Failed to solve " + file.getName());
            }

        }
    }
}