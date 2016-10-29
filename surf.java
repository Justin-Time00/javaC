package anyP;
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
			int Fun = 0;
			Fun = getFun(i,(arr[i][0]+arr[i][2]),Fun);
			if(Fun> maxFun)
				maxFun = Fun;
		}
		System.out.println(maxFun);
	}
	public static int getFun(int index,int time,int fun){
		if(index<arr.length-1){
			for(int i=index;i<arr.length;i++){
				if(arr[i][0]>=time){
					for(int j = i;j<arr.length;j++){
						int tempFun = 0;
						tempFun += getFun(i,time,fun);
						if(tempFun>fun)
							fun = tempFun;
					}
				}
			}
			return fun;
		}
		else
		return fun;
	}
}
