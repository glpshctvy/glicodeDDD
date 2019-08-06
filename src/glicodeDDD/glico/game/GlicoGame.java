package glicodeDDD.glico.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import glicodeDDD.glico.player.NotWinOutPlayers;
import glicodeDDD.glico.player.Player;
import glicodeDDD.glico.player.WinOutPlayers;

public class GlicoGame {

	private Scanner scan;

	private Point gamePoint;

	private WinOutPlayers winOutPlayers;

	private NotWinOutPlayers notWinOutPlayers;

	public GlicoGame() {
		scan = new Scanner(System.in);
		createPlayers();
		setGamePoint();
	}

	public void start() {
		while (!notWinOutPlayers.isLastOne()) {
			notWinOutPlayers.nextMoves();

			announcementOfMoves();

			NotWinOutPlayers winners = judgeWinner(notWinOutPlayers);

			if (Objects.isNull(winners)) {
				continue;
			}

			winners.getPoint();

			WinOutPlayers winOutPlayers = notWinOutPlayers.winOutIfReached(gamePoint);

			this.winOutPlayers.addAll(winOutPlayers);
		}

		announcementOfResults();
	}

	private void setGamePoint() {
		System.out.println("何ポイント先取にしますか。数字で入力してください。");

		this.gamePoint = new Point(scan.nextInt());
	}

	private void createPlayers() {
		System.out.println("プレーヤー数を入力してください。数字で入力してください。");

		int numberOfPlayers = scan.nextInt();
		List<Player> players = new ArrayList<>();

		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new Player("Player" + i + 1));
		}

		this.notWinOutPlayers = new NotWinOutPlayers(players);
	}

	private NotWinOutPlayers judgeWinner(NotWinOutPlayers notWinOutPlayers) {

		if (isDrawed(notWinOutPlayers)) {
			return null;
		}

		return notWinOutPlayers.getWinners();
	}

	private boolean isDrawed(NotWinOutPlayers players) {

		if (players.hasAllSuits()) {
			return true;
		}
		if (players.hasOnlyOneSuits()) {
			return true;
		}
		return false;
	}

	private void announcementOfResults() {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void announcementOfMoves() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
