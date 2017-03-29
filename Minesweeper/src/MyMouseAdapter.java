import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
public class MyMouseAdapter extends MouseAdapter {
	int counter = 0;
	int[][] mine2DArrayX = MinesAndAdjacent.mineCreatorX();
	int[][] mine2DArrayY = MinesAndAdjacent.mineCreatorY();
	final int rows = 9;
	final int columns =9;
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:	//Right mouse button	
			Component c1 = e.getComponent();
			while (!(c1 instanceof JFrame)) {
				c = c1.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame1 = (JFrame) c1;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);
			Insets myInsets1 = myFrame1.getInsets();
			int x2 = myInsets1.left;
			int y2 = myInsets1.top;
			e.translatePoint(-x2, -y2);
			int xi = e.getX();
			int yi = e.getY();
			myPanel1.x = xi;
			myPanel1.y = yi;
			myPanel1.mouseDownGridX = myPanel1.getGridX(xi, yi);
			myPanel1.mouseDownGridY = myPanel1.getGridY(xi, yi);
			myPanel1.repaint();

			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);



			//Mines not used anymore because the class Mines and Adjacent was created
			/*Color newColor = null;
			if(counter ==0){
				for (int i = 0; i < rows; i++) {

					if ((mineArrayX[i] == myPanel.mouseDownGridX)&&(mineArrayY[i]== myPanel.mouseDownGridY)){
						for (int j = 0; j < columns; j++) {


							myPanel.colorArray[mineArrayX[j]][mineArrayY[j]] = Color.BLACK;
							myPanel.repaint();


							counter++;

						}
					}
				}
			}*/

			Color newColor = null;
			if(counter ==0){
				for (int i = 0; i < 9; i++) {

					if ((mine2DArrayX[i][8] == myPanel.mouseDownGridX)&&(mine2DArrayY[i][8]== myPanel.mouseDownGridY)){

						for (int j = 0; j < 9; j++) {


							myPanel.colorArray[mine2DArrayX[j][8]][mine2DArrayY[j][8]] = Color.BLACK;
							myPanel.repaint();

							counter++;
							
							
							// Shows message when a mine is clicked and closes the program
							if(counter==9){
								JOptionPane.showMessageDialog(myFrame, "Game Over");
								System.exit(0);
								
							}

						}


					}


				}

			}






			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} 

				else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {

						//if for the mines(black color) can't paint them white.
						if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] !=Color.BLACK){


							Color wColor = Color.WHITE;

							do {
								newColor = Color.LIGHT_GRAY;

							} 
							while((newColor.equals(wColor)));
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = wColor;

							myPanel.repaint();


							//test code fill cells white


							if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] ==Color.WHITE){

								int planeX=myPanel.mouseDownGridX;
								int planeY=myPanel.mouseDownGridY;
								while(planeX!=9 && planeY!=9){
									for (int i = 0; i < 9; i++){


										if(planeX== mine2DArrayX[i][8]-1 && planeY== mine2DArrayY[i][8]){
											planeY++;
											planeX=myPanel.mouseDownGridX;
											break;
										}



									}

									planeX++;
									myPanel.colorArray[planeX][planeY] = Color.WHITE;
									myPanel.repaint();
									
								}

								int planeX1=myPanel.mouseDownGridX;
								int planeY1=myPanel.mouseDownGridY;
								while(planeX1!=-1 && planeY1!=-1){
									for (int w = 0; w < 9; w++){


										if(planeX1== mine2DArrayX[w][8]+1 && planeY1== mine2DArrayY[w][8]){
											planeY1--;
											planeX1=myPanel.mouseDownGridX;
											break;
										}






									}
									planeX1--;
									myPanel.colorArray[planeX1][planeY1] = Color.WHITE;
									myPanel.repaint();
									
								}
							}

							//end test code
						}



					}
				}

			}


			break;
		case 3:		//right mouse button paints red

			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2= c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame1 = (JFrame)c2;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets1 = myFrame1.getInsets();
			int x4 = myInsets1.left;
			int y4 = myInsets1.top;
			e.translatePoint(-x4, -y4);
			int x3 = e.getX();
			int y3 = e.getY();
			myPanel1.x = x3;
			myPanel1.y = y3;
			int gridX1 = myPanel1.getGridX(x3, y3);
			int gridY1 = myPanel1.getGridY(x3, y3);
			if ((myPanel1.mouseDownGridX == -1) || (myPanel1.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX1 == -1) || (gridY1 == -1)) {
					//Is releasing outside
					//Do nothing
				} 

				else {
					if ((myPanel1.mouseDownGridX != gridX1) || (myPanel1.mouseDownGridY != gridY1)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {


						Color newColor1 = Color.RED;

						myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = newColor1;
						myPanel1.repaint();

					}
				}

			}

			myPanel1.repaint();
			break;



		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}