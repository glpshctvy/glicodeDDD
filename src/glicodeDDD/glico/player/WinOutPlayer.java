package glicodeDDD.glico.player;

import glicodeDDD.glico.game.Rank;

public class WinOutPlayer {

	private Player player;

	private Rank rank;

	public WinOutPlayer(Player player) {
		this.player = player;
		this.rank = Rank.current();
	}

	public Player getPlayer() {
		return this.player;
	}

	public Rank getRank() {
		return this.rank;
	}

	public String getResult() {
		return this.player.getPlayerName().value() + this.rank.getRank();
	}
}
