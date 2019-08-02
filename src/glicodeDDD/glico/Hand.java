package glicodeDDD.glico;

import java.util.Random;

public class Hand {

	private Suits suits;

	public Hand(Suits suits) {
		this.suits = suits;
	}

	public static Hand select(int index) {
		Suits selected = Suits.valueOf(index);
		return new Hand(selected);
	}

	public static Hand anyOne() {
		Random random = new Random();
		int index = random.nextInt(3);
		return select(index);
	}

	public Hand getAdvantageousHand(Hand hand) {
		Suits advantageous = this.suits.getAdvantageousSuits();
		return new Hand(advantageous); 
	}

	public Hand getDisadvantageousSuits(Hand hand) {
		Suits disadvantageous = this.suits.getDisadvantageousSuits();
		return new Hand(disadvantageous); 
	}
}

enum Suits {

	GLICO("グリコ", 0), PINEAPPLE("パイナップル", 1), CHOCOLATE("チョコレート", 2);

	private String suitsName;

	private Point winningPoint;

	private int index;

	private Suits(String suitsName, int index) {
		this.suitsName = suitsName;
		this.winningPoint = new Point(suitsName.length());
		this.index = index;
	}

	public static Suits valueOf(int index) {
		return null;
	}
	
	public String suitsName() {
		return this.suitsName;
	}

	public Point winningPoint() {
		return this.winningPoint;
	}

	public int index() {
		return index;
	}

	public Suits getAdvantageousSuits() {
		switch (this) {
			case GLICO : return CHOCOLATE;
			case CHOCOLATE : return PINEAPPLE;
			case PINEAPPLE : return GLICO;
		}
		throw new IllegalArgumentException();
	}

	public Suits getDisadvantageousSuits() {
		switch (this) {
			case GLICO : return PINEAPPLE;
			case CHOCOLATE : return GLICO;
			case PINEAPPLE : return CHOCOLATE;
		}
		throw new IllegalArgumentException();
	}

}