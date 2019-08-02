package glicodeDDD.glico.player;

import java.util.List;

public class Players {

	private List<Player> players;

	public void add(Player player) {
		this.players.add(player);
	}

	public List<Player> getPlayers() {
		return this.players;
	}
}
