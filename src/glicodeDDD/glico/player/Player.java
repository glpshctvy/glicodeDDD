package glicodeDDD.glico.player;

public class Player {

	private PlayerId playerId;
	private PlayerName playerName;
	private PlayerPoint playerPoint;


	public Player(String name) {
		this.playerId = new PlayerId();
		this.playerName = new PlayerName(name);
		this.playerPoint = new PlayerPoint();
	}

	public void setNextMove() {

	}
	public PlayerId getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Player)){
			return false;
		}
		Player other = (Player)obj;
		return playerId.equals(other.getPlayerId());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

