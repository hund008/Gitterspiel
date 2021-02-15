public class KI {
	static int dx = 1000;
	static int dy = 820;

	public static void move() {
		int px = GitterSpiel.px;
		int py = GitterSpiel.py;
		if (dx >= 0 && dy >= 0 && dx <= 1200 && dy <= 900) {
			if (Math.abs(px - dx) > Math.abs(py - dy)) {
				if (px > dx) {
					dx += 20;
				} else
					dx -= 20;
			} else if (py > dy)
				dy += 20;
			else
				dy -= 20;
		}

		System.out.println(px);
		System.out.println(dx);
	}

}
