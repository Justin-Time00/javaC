package anyP;
import java.util.*;
public class majority {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = Integer.parseInt(scan.nextLine());
		int[][] votes = new int[testCase][1000];
		for(int i = 0;i<testCase;i++){
			int temp = Integer.parseInt(scan.nextLine());
			for(int j = 0;j<temp;j++){
				votes[i][j] = Integer.parseInt(scan.nextLine());				
			}
		}
		
		for(int i = 0;i<votes.length;i++){
			int[] result = new int[1000];
			for(int j = 0;j<votes[i].length;j++){
				if(votes[i][j]>0)
					result[votes[i][j]-1]++;
			}
			int max = -1;
			int res = -1;
			for(int o = 0;o<result.length;o++){
				if(result[o]>max){
					max = result[o];
					res = o+1;
				}		
			}
			System.out.println(res);
		}

	}

}
