package glicodeDDD.glico.player;

import glicodeDDD.glico.game.Hand;

public class NotWinOutPlayer {

	private Hand hand;

	private Player player;

	public NotWinOutPlayer(Player player) {
		this.player = player;
	}

	public PlayerId getPlayerId() {
		return this.player.getPlayerId();
	}

	public void nextMove() {
		
	}

	public Player winOut() {
		return player;
	}

}
