package glicodeDDD.glico.player;

import glicodeDDD.glico.Hand;

public class EntryPlayer {

	private PlayerId playerId;

	private Hand hand;

	public EntryPlayer(PlayerId playerId, Hand hand) {
		this.playerId = playerId;
		this.hand = hand;
	}
}
