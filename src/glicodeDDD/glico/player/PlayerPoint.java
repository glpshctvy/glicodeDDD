package glicodeDDD.glico.player;

import glicodeDDD.glico.game.Point;

public class PlayerPoint {

	private Point point;

	public PlayerPoint() {
		this.point = new Point(0);
	}

	public void plus(Point point) {
		this.point.plus(point);
	}

	public Point getPoint() {
		return this.point;
	}

}
