package glicodeDDD.glico.player;

import java.util.ArrayList;
import java.util.List;

import glicodeDDD.glico.game.Hand;
import glicodeDDD.glico.game.Point;

public class NotWinOutPlayers {

	private List<NotWinOutPlayer> notWinOutPlayers;

	public NotWinOutPlayers(List<Player> players) {
		List<NotWinOutPlayer> notWinOutPlayers = new ArrayList<>();
		for(Player player : players) {
			notWinOutPlayers.add(new NotWinOutPlayer(player));
		}
		
		this.notWinOutPlayers = notWinOutPlayers;
	}
	
	public boolean isLastOne() {
		return notWinOutPlayers.size() == 1;
	}

	public void nextMoves() {
		notWinOutPlayers.forEach(NotWinOutPlayer::nextMove);
	}

	public NotWinOutPlayers getWinners() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public boolean hasAllSuits() {
//		return notWinOutPlayers.containsAll(Hand.Suits)
//				&& notWinOutPlayers.contains(Hand.CHOCOLATE)
//				&& notWinOutPlayers.contains(Hand.PINEAPPLE);

		return false;
	}

	public boolean hasOnlyOneSuits() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public WinOutPlayers winOutIfReached(Point gamePoint) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void getPoint() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
