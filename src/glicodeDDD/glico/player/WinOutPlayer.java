package glicodeDDD.glico.player;

import glicodeDDD.glico.game.Rank;

public class WinOutPlayer {

	private Player player;

	private Rank rank;

	public WinOutPlayer(Player player) {
		this.player = player;
		this.rank = Rank.current();
	}

	public Object getPlayer() {
		return this.player;
	}
}
