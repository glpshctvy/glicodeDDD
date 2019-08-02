package glicodeDDD.glico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import glico.Hands;
import glicodeDDD.glico.player.NotWinOutPlayers;
import glicodeDDD.glico.player.Player;
import glicodeDDD.glico.player.Players;
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
		while(!notWinOutPlayers.isLastOne()) {
			// 手を決める。
			// 勝者を判定する。
			// 加点する。
			// 勝ち抜けの移動を行う。
		}
	}

	@SuppressWarnings("resource")
	private void setGamePoint() {
		System.out.println("何ポイント先取にしますか。数字で入力してください。");

		this.gamePoint = new Point(scan.nextInt());
	}


	@SuppressWarnings("resource")
	private void createPlayers() {
		System.out.println("プレーヤー数を入力してください。数字で入力してください。");

		int numberOfPlayers = scan.nextInt();
		List<Player> players = new ArrayList<>(); 

		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new Player("Player" + i+1 ));
		}

		this.notWinOutPlayers = new NotWinOutPlayers(players);
	}

	private Players judge(Hands hands) {

		if (isDrawed(hands)) {
			return new Players();
		}

		return hands.getWinningPlayers();
	}

	private boolean isDrawed(Hands hands) {
		if (hands.hasAllSuits()) {
			return true;
		}
		if (hands.hasOnlyOneSuits()) {
			return true;
		}
		return false;
	}

}
