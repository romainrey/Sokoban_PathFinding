import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class run {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		StringReader stringReader = new StringReader();
		List maze_list = stringReader.readFileInList();
		Maze maze = new Maze(maze_list);
		maze.getStartPos();
		Runner runner = new Runner(maze);
		ArrayList[] ans = new ArrayList[2];
		ans = runner.search(maze, maze.getStart_i(), maze.getStart_j());
		System.out.println(ans[0]);
		System.out.println(ans[1]);

	}

}
