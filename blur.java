package anyP;
import java.util.*;
import java.math.*;
public class blur {

	public static int row, col,bnum;
	public static int[][] newGrid,grid;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] temparr = input.split(" ");
		col = Integer.parseInt(temparr[0]);
		row = Integer.parseInt(temparr[1]);
		bnum = Integer.parseInt(temparr[2]);
		grid = new int[row][col];
		for(int i = 0;i<row;i++){
			input = scan.nextLine();
			temparr = input.split(" ");
			for(int j = 0;j<col;j++){
				grid[i][j]=Integer.parseInt(temparr[j]);
			}
		}
		newGrid = new int[row][col];
		for(int i = 0;i<bnum;i++){
			blurMePLZ();
			grid = newGrid;
			newGrid = new int[row][col];
		}
		
		int[] result = new int[(int)Math.pow(9,bnum)+1];
		for(int i = 0;i<row;i++)
			for(int j = 0; j<col;j++){
				result[grid[i][j]] = 1;
			}
			
		int count = 0;
		for(int i = 0;i<result.length;i++)
			if(result[i]==1){
				count++;
			}
		System.out.println(count);
		
	}
	public static void blurMePLZ(){
		for(int i = 0;i<row;i++){
			for(int j = 0;j<col;j++){
				int tempNum = grid[i][j]+
						grid[(i+1)%row][j]+
						grid[(i-1+row)%row][j]+
						grid[i][(j+1)%col]+
						grid[i][(j-1+col)%col]+
						grid[(i-1+row)%row][(j-1+col)%col]+
						grid[(i-1+row)%row][(j+1)%col]+
						grid[(i+1)%row][(j-1+col)%col]+
						grid[(i+1)%row][(j+1)%col];
				newGrid[i][j]= tempNum;
			}
		}
	}

}
