package glicodeDDD.glico.game;

public class Rank {

	private static int sequence = 1;

	private int rank;


	private Rank(int rank) {
		this.rank = rank;
	}

	public static Rank current() {
		return new Rank(sequence);
	}

	public static void countUp(int size) {
		sequence += size;
	}

	public String getRank() {
		return rank + "位";
	}
}
