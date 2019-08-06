package glicodeDDD.glico.player;

import java.util.List;

public class WinOutPlayers {
	private List<WinOutPlayer> players;

	private static int rank = 1;

	public void add(WinOutPlayer player) {
		this.players.add(player);
	}
	
	public void addAll(WinOutPlayers players) {
		this.players.addAll(players.getList());
	}

	private List<WinOutPlayer> getList() {
		return this.players;
	}
}
