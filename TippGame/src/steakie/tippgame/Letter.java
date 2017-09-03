package steakie.tippgame;

import java.awt.Color;
import java.util.Random;

public class Letter {

	private int x;
	public double y;
	private String letter;
	private Color color;
	private int size;
	private Random random = new Random();

	public Letter(String letter, int x, double y, int size) {
		this.letter = letter;
		this.x = x;
		this.y = y;
		color = getRdmColor();
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public int getX() {
		return x;
	}
	
	public Color getRdmColor() {
		Color c = null;
		int rdm = random.nextInt(8);
		switch(rdm) {
			case 0: c = new Color(0x00ff00);
			break;
			case 1: c = new Color(0xff00ff);
			break;
			case 2: c = Color.gray;
			break;
			case 3: c = Color.WHITE;
			break;
			case 4: c = new Color(0xffff00);
			break;
			case 5: c = new Color(0x00ffff);
			break;
			case 6: c = new Color(0xff0000);
			break;
			case 7: c = Color.orange;
			break;
		}
		
		return c;
	}

	public double getY() {
		return y;
	}

	public String getLetter() {
		return letter;
	}

	public Color getColor() {
		return color;
	}

}
