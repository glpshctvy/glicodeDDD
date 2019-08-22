package glicodeDDD.glico.player;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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
		if(players.isEmpty()) return;
		this.players.addAll(players.players);
	}

	List<Player> getPlayers() {
		List<Player> result = new ArrayList<>();
		players.forEach(p -> result.add(p.getPlayer()));
		return result;
	}

	public boolean isEmpty() {
		return players.size() == 0;
	}

	public String getResult() {
		StringJoiner joiner = new StringJoiner(", ");
		this.players.forEach(players -> joiner.add(players.getResult()));
		return joiner.toString();
	}
}
