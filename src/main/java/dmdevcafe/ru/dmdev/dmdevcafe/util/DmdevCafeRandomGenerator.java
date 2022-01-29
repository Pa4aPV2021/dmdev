package dmdevcafe.ru.dmdev.dmdevcafe.util;

import java.util.Random;

public class DmdevCafeRandomGenerator {
	private final static Random random = new Random();

	public static int nextInt(int max, int min) {
		return random.nextInt(max) + min;
	}
}
