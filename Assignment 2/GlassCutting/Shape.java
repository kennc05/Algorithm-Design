import java.util.Comparator;

/**
 * @Purpose: The shape class represents a single shape. DO NOT MODIFY THE
 *           SIGNITURE OF EXISTING METHODS, You may add additional methods if
 *           you wish
 * 
 * @author RYK
 * @since 30/10/2019 
 * extended by Kenneth 17045066
 * 
 **/

public class Shape implements Comparable<Shape> {

	private int sWidth;   // width of the shape
	private int sHeight;  // height of the shape

	/**
	 * A Shape constructor to set the width and height of a shape. 
	 * @param width of a shape
	 * @param height of a shape
	 **/
	public Shape(int width, int height) {

		// Shape width and height should not be greater than the sheet width and height
		if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
			throw new IllegalArgumentException("Shape width or height is not valid");
		}

		this.sWidth = width;
		this.sHeight = height;
	}

	/**
	 * @return height of a shape
	 **/
	public int getHeight() {
		return sHeight;
	}

	/**
	 * @return width of a shape
	 */
	public int getWidth() {
		return sWidth;
	}

	@Override
	public int compareTo(Shape o) {
		// You may want to implement this method
		return 0;
	}

	//HELPER FUNCTION: Rotate shape 90 degrees by swapping width and height 
	public void rotateShape () {
		int tempWidth = sWidth;
		sWidth = sHeight;
		sHeight = tempWidth;
	}

	public int getArea () {
		return getWidth() * getHeight();
	}

	//HELPER FUNCTION: Output information about a shape
	public void outputShape () {
		System.out.printf("%-5s - %-17s | %-17s \n","", "Height: "+sHeight, "Width: "+sWidth);
	}

	//Added annonymous classes to help with comparasions: height, width and area
	
	//Compare by height - an annonymous comparator class
	public static Comparator<Shape> compareByHeight = new Comparator<Shape>() {
		public int compare(Shape s1, Shape s2) {
			return Integer.compare(s1.sHeight, s2.sHeight);
		}
	};

	//Compare by width - an annonymous comparator class
	public static Comparator<Shape> compareByWidth = new Comparator<Shape>() {
		public int compare(Shape s1, Shape s2) {
			return Integer.compare(s1.sWidth, s2.sWidth);
		}
	};

	//Compare by area - an annonymous comparator class
	public static Comparator<Shape> compareByArea = new Comparator<Shape>() {
		public int compare(Shape s1, Shape s2) {
			return Integer.compare(s1.getArea(), s2.getArea());
		}
	};
}
