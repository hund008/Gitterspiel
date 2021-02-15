public class KI {
	int dx = 1000;
	int dy = 820;
	GitterSpiel frame;

	public KI(GitterSpiel frame) {
		this.frame = frame;
	}

	public void move() {
		int px = frame.px;
		int py = frame.py;
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
