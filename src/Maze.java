import java.util.*;

public class Maze {
    //Attributes
    private int[] dimensions;
    private int[] start;
    private int[] finish;
    private char[][] map;
    private int[][] moves = new int[][]{
        {0, 1},
        {1, 0},
        {-1, 0},
        {0, -1}
    };
    private Set<int[]> visited = new HashSet<>();

    //Constructors
    public Maze(int[] dimensions, int[] start, int[] finish, char[][] map){
        this.dimensions = dimensions;
        this.start = start;
        this.finish = finish;
        this.map = map;

        this.markMap(start,'S');
        this.markMap(finish,'E');
    }

    //Getters&Setters
    public char[][] getMap() {
        return map;
    }
    public int[] getStart() {
        return start;
    }


    //Methods
    private void markMap(int[] loc){
        int x = loc[0];
        int y = loc[1];
        this.map[y][x] = 'x';
    }

    private void markMap(int[] loc, char marker){
        int x = loc[0];
        int y = loc[1];
        this.map[y][x] = marker;
    }

    public void showMap(){
        for (int i=0; i < this.map.length; i++) {
            String line = new String(this.map[i]);
            System.out.println(line.replace('1', '#').replace('0', ' '));
        }
    }

    public boolean solve(int[] loc){
        //Stop if we're at the finish
        if (loc[0] == this.finish[0] && loc[1] == this.finish[1]) {
            boolean complete = true;
            return complete;
        }
        else {
            //Else for each valid move (N, S, E, W) from this position
            for(int[] move : moves){
                int[] new_loc = {loc[0]+move[0], loc[1]+move[1]};
                //If move is valid, add it to our visited path so we don't come back, and recursively call this
                // function with the new position
                if(validate_move(new_loc)){
                    visited.add(new_loc);
                    if(solve(new_loc)){
                        boolean complete = true;
                        this.markMap(loc);
                        return complete;
                    }
                }
            }
            boolean completed = false;
            return completed;
        }
    }

    private boolean validate_move(int[] loc){
        boolean valid = false;

        if (this.getMap()[loc[1]][loc[0]] != '1'){
            valid = true;
        }

        for(int[] record : visited) {
            if (record[0] == loc[0] && record[1] == loc[1]) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
