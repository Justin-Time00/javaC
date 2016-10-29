package anyP;

public class grid {
	public static int[][] grid = {{2,1,2,0},{1,2,0,3},{3,1,1,3},{1,1,2,0},{1,1,1,0}};
	public static int row = 5, col = 4;
	public static void main(String[] args) {
		grid[4][3]=99;
		if(checkBot(0,0)){
			goBot(0,0);
			grid[grid[0][0]][0]=0;
		}
		if(checkRight(0,0)){
			goRight(0,0);
			grid[0][grid[0][0]]=0;
		}
		for(int i =0;i<grid.length;i++){
			for(int j = 0;j<grid[i].length;j++)
				System.out.print(grid[i][j]+" ");
			System.out.println("");
		}
	}
	
	public static void goTop(int x, int y){
		int value = grid[x][y];
		int currentX= x-value;
		int currentY = y; 
		int current = grid[currentX][currentY];
		if(checkTop(currentX,currentY)){
			goTop(currentX,currentY);
			grid[currentX-current][currentY]=0;
		}
		if(checkRight(currentX,currentY)){
			goRight(currentX,currentY);
			grid[currentX][currentY+current]=0;
		}
		if(checkLeft(currentX,currentY)){
			goLeft(currentX,currentY);
			grid[currentX][currentY-current]=0;
		}
		if(value!=current){
			if(checkBot(currentX,currentY)){
				goBot(currentX,currentY);
				grid[currentX+current][currentY]=0;
			}
		}
	}
	
	public static void goBot(int x, int y){
		int value = grid[x][y];
		int currentX= x+value;
		int currentY = y; 
		int current = grid[x+value][y];
		if(checkBot(currentX,currentY)){
			goBot(currentX,currentY);
			grid[currentX+current][currentY]=0;
		}
		if(checkRight(currentX,currentY)){
			goRight(currentX,currentY);
			grid[currentX][currentY+current]=0;
		}
		if(checkLeft(currentX,currentY)){
			goLeft(currentX,currentY);
			grid[currentX][currentY-current]=0;
		}
		if(value!=current){
			if(checkTop(currentX,currentY)){
				goTop(currentX,currentY);
				grid[currentX-current][currentY]=0;
			}
		}
	}
	
	public static void goRight(int x, int y){
		int value = grid[x][y];
		int currentX= x;
		int currentY = y+value; 
		int current = grid[x][y+value];
		if(checkTop(currentX,currentY)){
			goTop(currentX,currentY);
			grid[currentX-current][currentY]=0;
		}
		if(checkRight(currentX,currentY)){
			goRight(currentX,currentY);
			grid[currentX][currentY+current]=0;
		}
		if(checkBot(currentX,currentY)){
			goBot(currentX,currentY);
			grid[currentX+current][currentY]=0;
		}
		if(value!=current){
			if(checkLeft(currentX,currentY)){
				goLeft(currentX,currentY);
				grid[currentX][currentY-current]=0;
			}
		}
	}
	
	public static void goLeft(int x, int y){
		int value = grid[x][y];
		int currentX= x-value;
		int currentY = y; 
		int current = grid[x-grid[x][y]][y];
		if(checkTop(currentX,currentY)){
			goTop(currentX,currentY);
			grid[currentX-current][currentY]=0;
		}
		if(checkLeft(currentX,currentY)){
			goLeft(currentX,currentY);
			grid[currentX][currentY-current]=0;
		}
		if(checkBot(currentX,currentY)){
			goBot(currentX,currentY);
			grid[currentX+current][currentY]=0;
		}
		if(value!=current){
			if(checkRight(currentX,currentY)){
				goRight(currentX,currentY);
				grid[currentX][currentY+current]=0;
			}
		}
	}
	
	public static boolean checkRight(int indexX,int indexY){
		int num = grid[indexX][indexY];
		if(indexY+num<col && grid[indexX][indexY+num]!=0)
			return true;
		else return false;
	}
	public static boolean checkLeft(int indexX,int indexY){
		int num = grid[indexX][indexY];
		if(indexY-num>=0 && grid[indexX][indexY-num]!=0)
			return true;
		else return false;
	}
	public static boolean checkTop(int indexX,int indexY){
		int num = grid[indexX][indexY];
		if(indexX-num>0  && grid[indexX-num][indexY]!=0)
			return true;
		else return false;
	}
	public static boolean checkBot(int indexX,int indexY){
		int num = grid[indexX][indexY];
		if(indexX+num<row  && grid[indexX+num][indexY]!=0)
			return true;
		else return false;
	}

}
