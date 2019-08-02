package glicodeDDD.glico.player;

import java.util.List;

public class NotWinOutPlayers {

	private List<Player> players;

	public NotWinOutPlayers(List<Player> players) {
		this.players = players;
	}
	
	public boolean isLastOne() {
		return players.size() == 1;
	}

	public Player winOut(PlayerId playerId) {
		for (Player player : players) {
			if(player.getPlayerId().equals(playerId)) {
				players.remove(player);
				return player;
			}
		}
		throw new IllegalArgumentException();
		
	}
	

}
