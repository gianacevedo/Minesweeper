import java.util.ArrayList;

public class adjacent {
	
	
	public static int[] adjCellsX(int[] mineX){
		int[] mineArrayX = Mines.mineCreatorX();
		
		
		int[] a = new int[9];
		for(int i=0; i<9; i++){
			mineX[i] = mineArrayX[i];
			if(i==0){a[i]= mineX[i]-1; }
			if(i==1){a[i]= mineX[i]; }
			if(i==2){a[i]= mineX[i]+1;}
			if(i==3){a[i]= mineX[i]-1;}
			if(i==4){a[i]= mineX[i]+1;}
			if(i==5){a[i]= mineX[i]-1; }
			if(i==6){a[i]= mineX[i]; }
			if(i==7){a[i]= mineX[i]+1; }
			
		}
		
		return a;
	}
	
	
	
	
public static int[] adjCellsY(int[] mineY){
		int[] mineArrayY = Mines.mineCreatorY();
	int[] a = new int[9];
	for(int i=0; i<9; i++){
		mineY[i] = mineArrayY[i];
		if(i==0){a[i]= mineY[i]+1; }
		if(i==1){a[i]= mineY[i]+1; }
		if(i==2){a[i]= mineY[i]+1;}
		if(i==3){a[i]= mineY[i];}
		if(i==4){a[i]= mineY[i];}
		if(i==5){a[i]= mineY[i]-1; }
		if(i==6){a[i]= mineY[i]-1; }
		if(i==7){a[i]= mineY[i]-1; }
		
		
			
		}
		return a;
	}
	
	
}