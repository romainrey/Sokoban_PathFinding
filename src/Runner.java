import java.util.ArrayList;

public class Runner {
	
	int[][] map;
	int limit_i;
	int limit_j;

	

	public Runner(Maze maze) {
		super();
		this.limit_i = maze.getDepth()-1;
		this.limit_j = maze.getLength()-1;
		this.map = new int[maze.getDepth()][maze.getLength()];
	}


	public boolean explore(Maze maze,int i,int j) {
		System.out.println(i);
		System.out.println(j);
		System.out.println(maze.getValue(i, j));
		if(map[i][j]==0) {
			if(maze.getValue(i, j)=='.') {
				System.out.println("found");
				maze.answer_vect_i.add(i);
				maze.answer_vect_j.add(j);
				map[i][j]=1;
				return true;
			}
			else if(((maze.getValue(i, j)=='#' | maze.getValue(i, j)=='*') | maze.getValue(i, j)=='$'))  {
				map[i][j] = 1;
				return false;
			}		
			boolean not_found = true;
			int iter = 0;
			int i_new = -1;
			int j_new = -1;
			while(not_found & iter<5) {
				System.out.println("iter"+iter);
				if(iter==0 & i>1) {
					i_new = i-1;
					j_new = j;
					not_found = !explore(maze,i-1,j);
				}
				else if(iter==1 & j<(limit_j-1)) {
					i_new = i;
					j_new = j+1;
					not_found = !explore(maze,i,j+1);
				}
				else if(iter==2 & i<(limit_i-1)) {
					i_new = i+1;
					j_new = j;
					not_found = !explore(maze,i+1,j);
				}
				else if(iter==4 & j>1) {
					i_new = i;
					j_new = j-1;
					not_found = !explore(maze,i,j-1);
				}
				iter++;
			}
			map[i][j] = 1;
			if(!not_found) {
				maze.answer_vect_i.add(i_new);
				maze.answer_vect_j.add(j_new);
			}
			return !not_found;
		}
		else {
			return false;
		}
	}
	
	public ArrayList[] search(Maze maze, int dep_i, int dep_j) throws InterruptedException {
		explore(maze, dep_i, dep_j);
		
		ArrayList[] ans = new ArrayList[2];
		ans[0] = maze.answer_vect_i;
		ans[1] = maze.answer_vect_j;
		return ans;
	}
}
