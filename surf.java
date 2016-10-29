
public class surf {
	public static int[][] arr = {{2079,809484,180},
			{2133, 989250,2036},
			{2619,958859,712},
			{2731,875483,10},
			{3732,560423,483},
			{5333,170775,1393},
			{7659,699612,3960},
			{7850,669453,842},
			{7856,831372,3673},
			{8347,336421,2509}};
	public static void main(String[] args) {
		int maxFun = 0;
		for(int i =0;i<arr.length;i++){
			int time = 0;
			int maxNum = 0;
			maxNum = getFun(i,time);
			if(maxNum>maxFun)
				maxFun=maxNum;
		}
		/*for(int i =0;i<arr.length;i++){
			int time = 0;
			int maxNum = 0;
			for(int j = i;j<arr.length;j++){
				if(arr[j][0]>=time){
					int maxNum2 = 0;
					for(int o = j;o<arr.length;o++){
						maxNum2 += arr[o][1];
					}
					if(maxNum2>maxNum)
						maxNum= maxNum2;
				}
			}
			if(maxFun>maxNum)
				maxFun = maxNum;
		}*/
		System.out.println(maxFun);
	}
	public static int getFun(int x,int time){
		int max = 0;
		if(time<=arr[x][0]){
			for(int i = x;i<arr.length;i++){
				int tempfun =0;
				time = arr[i][0]+arr[i][2];
				tempfun = getFun(i,time)+arr[i][1];
				if(tempfun>max)
					max=tempfun;
			}
		}
		return max;
	}
}
