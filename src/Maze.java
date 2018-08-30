import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Maze {

	private char[][] matrix;
	
	public ArrayList answer_vect_i = new ArrayList();
	public ArrayList answer_vect_j = new ArrayList();
	
	private int length;
	
	private int depth;

	private int start_i;

	private int start_j;
		

	public char[][] getMatrix() {
		return matrix;
	}

	public int getLength() {
		return length;
	}

	public int getDepth() {
		return depth;
	}
	
	public int getStart_i() {
		return start_i;
	}
	
	public int getStart_j() {
		return start_j;
	}

	public Maze(List l) {
		super();
		Iterator iter = l.iterator();
		String first = (String) iter.next();
		this.length = first.length();
		this.depth = l.size();
		
		char[][] matrix = new char[this.depth][this.length];
		Iterator<String> itr = l.iterator();
		String s;
		char[] m;
		int i = 0;
		while (itr.hasNext())
		{
			s = itr.next();
			m = s.toCharArray();
			matrix[i] = m;
			i = i+1;   
	  }
		
		this.matrix = matrix;
	}
	
	public char getValue(int i, int j) {
		char value = this.matrix[i][j];
		return value;
	}
	
	public void getStartPos() {
		for (int i=0; i<((this.depth)-1); i++) {
			for (int j=0; j<((this.length)-1); j++) {
				if(this.getValue(i, j)=='@') {
					this.start_i = i;
					this.start_j = j;
				}
			}
		}
		return;
	}
	
}
