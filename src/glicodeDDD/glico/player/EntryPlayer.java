package glicodeDDD.glico.player;

import java.util.Scanner;

import glicodeDDD.glico.game.Point;
import glicodeDDD.glico.janken.Hand;

public class EntryPlayer {

	private Player player;

	private Hand hand;

	public EntryPlayer(Player player) {
		this.player = player;
	}

	public void nextMove(Scanner scan) {
		if(player.isComputer()) {
			this.hand = Hand.anyOne();
		} else {
			System.out.println("数字で入力してください。0:グー、1:パー、2:チョキ");
			this.hand = Hand.select(scan.nextInt());
		}
	}

	public Player getPlayer() {
		return this.player;
	}

	public Hand getHand() {
		return this.hand;
	}

	public void getPoint() {
		this.player.addPoint(this.hand.winningPoint());
	}

	public boolean isReached(Point gamePoint) {
		PlayerPoint point = this.player.getPlayerPoint();
		return point.isReached(gamePoint);
	}

	public WinOutPlayer winOut() {
		return new WinOutPlayer(this.player);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EntryPlayer)) {
			return false;
		}
		EntryPlayer other = (EntryPlayer) obj;
		Player otherPlayer = other.getPlayer();
		return this.player.getPlayerId().equals(otherPlayer.getPlayerId());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
