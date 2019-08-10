package glicodeDDD.glico.janken;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import glicodeDDD.glico.game.Point;

public enum Hand {

	GLICO(Suits.ROCK, "グリコ"), PINEAPPLE(Suits.PAPER , "パイナップル"), CHOCOLATE(Suits.SCISSORS, "チョコレート");

	private Suits suits;

	private String handName;

	private Point winningPoint;

	private Hand(Suits suits, String handName) {
		this.suits = suits;
		this.handName = handName;
		this.winningPoint = new Point(handName.length());
	}

	public static Hand select(int index) {
		Suits selected = Suits.valueOf(index);
		return getHand(selected);
	}

	public static Hand anyOne() {
		Random random = new Random();
		int index = random.nextInt(3);
		return select(index);
	}

	private static Hand getHand(Suits suits) {
		for (Hand hand : Hand.values()) {
			if (hand.suits == suits) {
				return hand;
			}
		}
		throw new IllegalArgumentException();
	}

	public Hand getAdvantageousHand() {
		Suits advantageous = this.suits.getAdvantageousSuits();
		return getHand(advantageous); 
	}

	public Hand getDisadvantageousHand() {
		Suits disadvantageous = this.suits.getDisadvantageousSuits();
		return getHand(disadvantageous); 
	}

	public List<Hand> getAllSuits() {
		return Arrays.asList(Hand.values());
	}

	public String suitsName() {
		return this.handName;
	}

	public Point winningPoint() {
		return this.winningPoint;
	}


}

enum Suits {

	ROCK(0), PAPER(1), SCISSORS(2);

	private int index;

	private Suits(int index) {
		this.index = index;
	}

	public static Suits valueOf(int index) {
		for (Suits suits : Suits.values()) {
			if (suits.index == index) {
				return suits;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public int index() {
		return index;
	}

	public Suits getAdvantageousSuits() {
		switch (this) {
			case ROCK : return SCISSORS;
			case SCISSORS : return PAPER;
			case PAPER : return ROCK;
		}
		throw new IllegalArgumentException();
	}

	public Suits getDisadvantageousSuits() {
		switch (this) {
			case ROCK : return PAPER;
			case SCISSORS : return ROCK;
			case PAPER : return SCISSORS;
		}
		throw new IllegalArgumentException();
	}

}