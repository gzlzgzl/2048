public class GenerateNumbers {

	public static boolean generate(int[][] arr){
		//find the places without values
		int record=0;
		for(int k=0;k<4;k++) {
			for(int y=0;y<4;y++) {
				if(arr[k][y]==0) {
					record++;
				}
			}
		}
		//choose which place to be filled in with number
		int Choosing=(int)(Math.random()*record+1);
		//find the place of the chosen empty block
		if(record==0) {
			System.out.println("Game over");
			return false;
		}else {
			for(int p=0;p<4;p++) {
				for(int o=0;o<4;o++) {
					if(arr[p][o]==0) {
						Choosing--;
					if(Choosing==0) {
						arr[p][o]=RandomNumber();	
					}
					}
				}
			}
		}//for else
		return true;
	}
	
	public static int RandomNumber() {
		int a=0;
		double h=Math.random();
		if(h<=0.3) {
			a=4;
		}else {
			a=2;
		}

		return a;
	}
}
