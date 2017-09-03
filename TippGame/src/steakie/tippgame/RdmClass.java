package steakie.tippgame;

import java.util.Random;

public class RdmClass {

	private Random random = new Random();

	public RdmClass() {

	}

	public String rdmLetter() {
		int rdm = random.nextInt(26);
		switch (rdm) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "Z";
		case 3:
			return "C";
		case 4:
			return "D";
		case 5:
			return "E";
		case 6:
			return "F";
		case 7:
			return "Y";
		case 8:
			return "G";
		case 9:
			return "H";
		case 10:
			return "I";
		case 11:
			return "J";
		case 12:
			return "K";
		case 13:
			return "L";
		case 14:
			return "M";
		case 15:
			return "N";
		case 16:
			return "O";
		case 17:
			return "P";
		case 18:
			return "Q";
		case 19:
			return "R";
		case 20:
			return "S";
		case 21:
			return "T";
		case 22:
			return "U";
		case 23:
			return "V";
		case 24:
			return "W";
		case 25:
			return "X";
		default:
			return "a";

		}
	}

}
