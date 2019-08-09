package glicodeDDD.glico.janken;

import java.util.List;

public class Hands {
	private List<Hand> hands;

	public Hands(List<Hand> hands) {
		this.hands = hands;
	}

	public boolean containsAll(List<Hand> hands) {
		return this.hands.containsAll(hands);
	}

	public Hand firstOne() {
		return this.hands.get(0);
	}

	public boolean hasOnlyOneSuits(Hand suits) {
		for (Hand hand : this.hands) {
			if (hand != suits) {
				return false;
			}
		}
		return true;
	}

	public Hand strongerHand() {
		Hand firstOneSuits = firstOne();
		Hand strongerSuits = firstOne().getDisadvantageousHand();

		return this.hands.contains(strongerSuits) ? strongerSuits : firstOneSuits;
	}
}
