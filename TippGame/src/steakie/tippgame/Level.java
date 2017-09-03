package steakie.tippgame;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Level {

	private int width, height;
	public ArrayList<Letter> letters;
	public int misses;
	private Random random = new Random();
	public double timer;
	public double acc;
	public int speed;

	private RdmClass rdm;

	public Level(int w, int h, ArrayList<Letter> l, int misses, double timer, double acc) {
		rdm = new RdmClass();
		width = w;
		height = h;
		letters = l;
		this.misses = misses;
		this.timer = timer;
		this.acc = acc;
	}

	public void update() {
		for (int i = 0; i < letters.size(); i++) {
			if (letters.get(i).getY() > height - 1) {
				misses++;
				remove(letters.get(i));
			}
		}

		if (timer % (speed - (int) acc) == 0) {
			Letter l = new Letter(randomLetter(), random.nextInt(width - 120) + 20, 0 + misses * 10 + 60,
					// RGB Values
					random.nextInt(70) + 60);
			letters.add(l);
		}
	}

	public void render(Graphics g, Font f1) {
		for (Letter p : letters) {
			f1 = new Font("Arial", Font.BOLD, p.getSize());
			g.setFont(f1);
			g.setColor(p.getColor());
			g.drawString(p.getLetter(), p.getX(), (int) p.getY());
		}
	}

	private String randomLetter() {
		return rdm.rdmLetter();
	}

	public void remove(Letter letter) {
		letters.remove(letter);
	}

}
