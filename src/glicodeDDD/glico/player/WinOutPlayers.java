package glicodeDDD.glico.player;

import java.util.ArrayList;
import java.util.List;

public class WinOutPlayers {
	private List<WinOutPlayer> players;

	public WinOutPlayers() {
		this.players = new ArrayList<>();
	}

	public WinOutPlayers(List<WinOutPlayer> players) {
		this.players = players;
	}

	public void add(WinOutPlayer player) {
		this.players.add(player);
	}
	
	public void addAll(WinOutPlayers players) {
		if(players.getList().size() == 0) return;
		this.players.addAll(players.getList());
	}

	List<WinOutPlayer> getList() {
		return this.players;
	}
}
