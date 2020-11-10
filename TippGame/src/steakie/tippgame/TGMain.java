package steakie.tippgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import javax.swing.*;

public class TGMain extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private final static int width = 1280;
	private final static int height = 720;

	private Thread thread;
	private Graphics g;
	private boolean running = false;
	@SuppressWarnings("unused")
	private JFrame frame;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private boolean lost = false;
	private boolean playing = false;
	private Screen screen;
	private Keyboard keys;

	private Level level;
	private ArrayList<Letter> letters;

	private String difficulty;

	private Font f1;
	private Font f2;

	private Mouse mouse;

	private int score;
	private int misses;
	private double timer;
	private double acc = 2;

	public TGMain() {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);

		frame = this;
		keys = new Keyboard();
		mouse = new Mouse();
		screen = new Screen(width, height);
		letters = new ArrayList<>();
		f2 = new Font("Arial", Font.BOLD, 80);
		score = 0;
		misses = 0;
		level = new Level(width, height, letters, misses, timer, acc);
		addKeyListener(keys);
		addMouseListener(mouse);
	}

	private synchronized void start() {
		running = true;
		thread = new Thread(this, "Main");
		thread.start();
	}

	private synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		screen.clear();

		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		if (!lost) {
			level.render(g, f1);

			// Spawnheight
			g.setColor(Color.gray);
			g.fillRect(0, 0, width, level.misses * 10 + 35);

			// Score
			g.setColor(Color.GREEN);
			g.setFont(f2);

			if (score < 10) {
				g.drawString("" + score, width - 80, 120);
			} else if (score < 100) {
				g.drawString("" + score, width - 125, 120);
			} else {
				g.drawString("" + score, width - 170, 120);
			}

			if (!hasFocus()) {
				g.drawString("--- PAUSE ---", width / 2 - 235, height / 2 + 30);
			}

			if (!playing && hasFocus()) {
				g.setColor(Color.ORANGE);
				g.drawString("Easy", 150, height / 2 + 30);
				g.drawString("Normal", width / 2 - 145, height / 2 + 30);
				g.drawString("Hard", width - 350, height / 2 + 30);
			}

			// Misses
			g.setColor(Color.RED);
			g.drawString("" + level.misses, 40, 120);

		} else {
			g.setColor(Color.gray);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("GAME OVER | Your Score: " + score, width / 2 - 370, height / 2 + 20);
		}

		screen.drawBG();

		g.dispose();
		bs.show();

	}

	private void add(Letter letter) {
		letters.add(letter);
	}

	private void setDifficulty(String dif) {
		if (dif.equals("easy")) {
			level.speed = 100;
			level.acc = 1;
		}
		if (dif.equals("normal")) {
			level.speed = 60;
			level.acc = 2;
		}
		if (dif.equals("hard")) {
			level.speed = 40;
			level.acc = 2.6;
		}
	}

	private void update() {
		checkButton();

		if (!lost && hasFocus() && playing) {
			level.timer++;

			keys.update();

			if (keys.esc) {
				System.exit(0);
			}

			if (keys.back) {
				lost = true;
			}

			if (level.misses * 10 > height - 30) {
				lost = true;
				playing = false;
			}

			level.update();

			removeOnPress();

			// System.out.println(keys.a);

			if (difficulty.equals("easy")) {
				level.acc += 0.0015;
			}

			if (difficulty.equals("normal")) {
				level.acc += 0.002;
			}

			if (difficulty.equals("hard")) {
				level.acc += 0.003;
			}

			for (Letter l : letters) {
				l.y += level.acc;
			}
		} else {
			keys.update();
			if (keys.esc) {
				System.exit(0);
			}
			if (keys.enter) {
				level.misses = 0;
				score = 0;
				playing = false;
				letters.clear();
				lost = false;
			}
		}

	}

	private int keytimer = 0;
	private int keycounter = 0;

	private void removeOnPress() {
		if (keytimer != 0) {
			keycounter++;
		}
		if (keycounter % (20 - (score / 15)) == 0) {
			keytimer = 0;
		}

		if (keys.a && keytimer == 0) {
			suchen("A");
		}
		if (keys.b && keytimer == 0) {
			suchen("B");
		}
		if (keys.c && keytimer == 0) {
			suchen("C");
		}
		if (keys.d && keytimer == 0) {
			suchen("D");
		}
		if (keys.e && keytimer == 0) {
			suchen("E");
		}
		if (keys.f && keytimer == 0) {
			suchen("F");
		}
		if (keys.g && keytimer == 0) {
			suchen("G");
		}
		if (keys.h && keytimer == 0) {
			suchen("H");
		}
		if (keys.i && keytimer == 0) {
			suchen("I");
		}
		if (keys.j && keytimer == 0) {
			suchen("J");
		}
		if (keys.k && keytimer == 0) {
			suchen("K");
		}
		if (keys.l && keytimer == 0) {
			suchen("L");
		}
		if (keys.m && keytimer == 0) {
			suchen("M");
		}
		if (keys.n && keytimer == 0) {
			suchen("N");
		}
		if (keys.o && keytimer == 0) {
			suchen("O");
		}
		if (keys.p && keytimer == 0) {
			suchen("P");
		}
		if (keys.q && keytimer == 0) {
			suchen("Q");
		}
		if (keys.r && keytimer == 0) {
			suchen("R");
		}
		if (keys.s && keytimer == 0) {
			suchen("S");
		}
		if (keys.t && keytimer == 0) {
			suchen("T");
		}
		if (keys.u && keytimer == 0) {
			suchen("U");
		}
		if (keys.v && keytimer == 0) {
			suchen("V");
		}
		if (keys.w && keytimer == 0) {
			suchen("W");
		}
		if (keys.x && keytimer == 0) {
			suchen("X");
		}
		if (keys.y && keytimer == 0) {
			suchen("Y");
		}
		if (keys.z && keytimer == 0) {
			suchen("Z");
		}

	}

	private void suchen(String l) {
		keytimer++;
		for (int i = 0; i < letters.size(); i++) {
			if (letters.get(i).getLetter() == l) {
				score++;
				level.remove(letters.get(i));
				keycounter = 0;
				return;
			}
		}
		level.misses++;
	}

	private void checkButton() {
		if (mouse.x >= 150 && mouse.x <= 320 && mouse.y >= height / 2 - 30 && mouse.y <= height / 2 + 30 && !playing) {
			setDifficulty("easy");
			difficulty = "easy";
			playing = true;
			mouse.x = 0;
			mouse.y = 0;
		}

		if (mouse.x >= 500 && mouse.x <= 770 && mouse.y >= height / 2 - 30 && mouse.y <= height / 2 + 30 && !playing) {
			setDifficulty("normal");
			difficulty = "normal";
			playing = true;
			mouse.x = 0;
			mouse.y = 0;
		}

		if (mouse.x >= 940 && mouse.x <= 1120 && mouse.y >= height / 2 - 30 && mouse.y <= height / 2 + 80 && !playing) {
			setDifficulty("hard");
			difficulty = "hard";
			playing = true;
			mouse.x = 0;
			mouse.y = 0;
		}
	}

	public void run() {
		long last = System.nanoTime();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - last) / ns;
			last = now;
			while (delta >= 1) {
				update();

				delta--;
			}
			render();
		}
		stop();
	}

	public static void main(String[] args) {
		TGMain game = new TGMain();
		game.setResizable(false);
		game.setVisible(true);
		game.setTitle("Tipp17 - Kappa");
		game.getFocusableWindowState();
		game.pack();
		game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		game.setLocationRelativeTo(null);

		game.start();
	}

}
