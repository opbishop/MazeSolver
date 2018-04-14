import java.io.File;

public class main {
    public static void main(String args[]) {
        MazeReader mazeReader = new MazeReader();

        File folder = new File("mazes");
        File[] listOfFiles = folder.listFiles();

        for(int i=0; i<listOfFiles.length; i++){
            Maze maze = mazeReader.readMaze(listOfFiles[i]);
            maze.solve(maze.getStart());
            maze.showMap();
        }



    }
}