package dataStructures.Recursion;

public class englishRuler {

	public static void drawRuler(int nInches, int majorLength) {
		drawLine(majorLength,0);	//Draws 0 inch line
		for (int j = 1; j < nInches; j++) {
			drawInterval(majorLength - 1);
			drawLine(majorLength,j); //Draws inch j line with label
		}
	}
	
	private static void drawInterval(int centralLength) {
		if(centralLength >= 1) {	//Draw if and only if central line is bigger or equal to one
			drawInterval(centralLength - 1);
			drawLine(centralLength);
			drawInterval(centralLength - 1);
		}
	}
	
	private static void drawLine(int tickLength, int tickLabel) {
		for(int j = 0; j < tickLength; j++) {
			System.out.print("-");
			if(tickLabel >= 0) {
				System.out.print(" " + tickLabel);
				System.out.print("\n");
			}
		}
	}
	
	private static void drawLine(int tickLength) {//Draws line but not label
		drawLine(tickLength, -1);
	}
}
