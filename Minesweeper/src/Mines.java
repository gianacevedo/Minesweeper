import java.util.Random;

public class Mines extends MyMouseAdapter {
	 private int x=0;
	 private int y=0;
	 Random r = new Random();
Mines[] theMines = new Mines[10];

public void oneMine(){
	this.x = r.nextInt(9);
	this.y = r.nextInt(9);
	
}
}
