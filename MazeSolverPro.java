import java.util.Random;
import java.util.Stack;

public class EnhancedMazeGenerator {
    private static final int WIDTH = 21;
    private static final int HEIGHT = 11;

    private static final char WALL = '#';
    private static final char PATH = ' ';
    private static final char START = 'S';
    private static final char END = 'E';
    private static final char VISITED = '.';

    private static char[][] maze = new char[HEIGHT][WIDTH];

    public static void main(String[] args) {
        generateMaze();
        visualizeMaze();

        solveMaze(1, 1);
        visualizeSolvedMaze();
    }

    private static void generateMaze() {
        // Initialize the maze with walls
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                maze[i][j] = WALL;
            }
        }

        Random rand = new Random();
        int startRow = rand.nextInt(HEIGHT);
        int endRow = rand.nextInt(HEIGHT);
        maze[startRow][0] = START;
        maze[endRow][WIDTH - 1] = END;

        generateMazeRecursive(1, 1);
    }

    private static void generateMazeRecursive(int row, int col) {
        maze[row][col] = PATH;

        int[] directions = {0, 1, 2, 3};
        shuffleArray(directions);

        for (int direction : directions) {
            int newRow = row + 2 * ((direction == 1) ? 1 : (direction == 3) ? -1 : 0);
            int newCol = col + 2 * ((direction == 0) ? 1 : (direction == 2) ? -1 : 0);

            if (isValid(newRow, newCol) && maze[newRow][newCol] == WALL) {
                maze[newRow][newCol] = PATH;
                maze[row + (newRow - row) / 2][col + (newCol - col) / 2] = PATH;
                generateMazeRecursive(newRow, newCol);
            }
        }
    }

    private static void visualizeMaze() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private static void solveMaze(int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            row = current[0];
            col = current[1];

            if (maze[row][col] == END) {
                break;
            }

            maze[row][col] = VISITED;

            int[][] directions = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
            shuffleArray(directions);

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValid(newRow, newCol) && maze[newRow][newCol] != VISITED) {
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
    }

    private static void visualizeSolvedMaze() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH;
    }

    private static void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
