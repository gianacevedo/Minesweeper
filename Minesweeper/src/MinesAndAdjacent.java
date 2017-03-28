
public class MinesAndAdjacent {

	
	public static int[][] mineCreatorX() {
		// mine position X
		
		//array for all the positions including adjacent.
		int [][] mineX = new int[9][9];
		int[] a = new int[9];
		for (int i = 0; i < 9; i++) {
			a[i] = (int) (Math.random() * 9);
			
			
			{mineX[i][0]= a[i]-1; }
			{mineX[i][1]= a[i]; }
			{mineX[i][2]= a[i]+1;}
			{mineX[i][3]= a[i]-1;}
			{mineX[i][4]= a[i]+1;}
			{mineX[i][5]= a[i]-1; }
			{mineX[i][6]= a[i]; }
			{mineX[i][7]= a[i]+1; }
			// last one is the position of the mine
			{mineX[i][8]= a[i]; }
			
			for (int j = 0; j < i; j++) {
				
				if (a[i] == a[j]) {
					i--; 
					break;

				}
				

			}

		}
		return mineX;
	}
	public static int[][] mineCreatorY() {
		int[] a = new int[9];
		int [][] mineY = new int[9][9];
		
		
		for (int i = 0; i < 9; i++) {
			a[i] = (int) (Math.random() * 9);
			    {mineY[i][0]= a[i]-1;}
				{mineY[i][1]= a[i];}
				{mineY[i][2]= a[i]+1;}
				{mineY[i][3]= a[i]-1;}
				{mineY[i][4]= a[i]+1;}
				{mineY[i][5]= a[i]-1;}
				{mineY[i][6]= a[i];}
				{mineY[i][7]= a[i]+1;}
				// last one is the position of the mine
				{mineY[i][8]= a[i]; }
				
			for (int j = 0; j < i; j++) {
				
				if (a[i] == a[j]) {
					i--; 
					break;

				}
				
				

			}

		}
		return mineY;
	}
}
