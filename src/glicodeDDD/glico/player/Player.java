package glicodeDDD.glico.player;

import glicodeDDD.glico.game.Point;

public class Player {

	private PlayerId playerId;
	private PlayerName playerName;
	private PlayerPoint playerPoint;
	private boolean isComputer = false;

	private Player (PlayerId playerId, PlayerName playerName, PlayerPoint playerPoint, boolean isComputer) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerPoint = playerPoint;
		this.isComputer = isComputer;
	}

	public static Player createPlayer(String name) {
		return new Player(new PlayerId(), new PlayerName(name), new PlayerPoint(), false);
	}

	public static Player createComputer(String name) {
		return new Player(new PlayerId(), new PlayerName(name), new PlayerPoint(), true);
	}

	public boolean isComputer() {
		return this.isComputer;
	}

	public PlayerId getPlayerId() {
		return this.playerId;
	}

	PlayerPoint getPlayerPoint() {
		return this.playerPoint;
	}

	PlayerName getPlayerName() {
		return this.playerName;
	}

	void getPoint(Point point) {
		playerPoint.plus(point);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		return playerId.equals(other.getPlayerId());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
