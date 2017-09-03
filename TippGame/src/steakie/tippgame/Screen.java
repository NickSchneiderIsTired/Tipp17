package steakie.tippgame;


public class Screen {

	private int width;
	private int height;
	public int[] pixels;
	private int BGColor;
	
	public Screen(int w, int h) {
		width = w;
		height = h;
		pixels = new int[w * h];
		BGColor = 0x004466;
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void drawBG() {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				pixels[x + y * width] = BGColor;
			}
		}
	}
	
	public void changeColor(int c) {
		BGColor = c;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
}
