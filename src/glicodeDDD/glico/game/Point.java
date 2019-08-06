package glicodeDDD.glico.game;

public class Point {

	private int point;

	public Point(int point) {
		this.point = point;
	}

	public int intValue() {
		return this.point;
	}

	public Point plus(Point point) {
		return new Point(this.point + point.intValue());
	} 

}
