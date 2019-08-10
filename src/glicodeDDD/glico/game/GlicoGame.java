package glicodeDDD.glico.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import glicodeDDD.glico.janken.Hand;
import glicodeDDD.glico.janken.Hands;
import glicodeDDD.glico.player.EntryPlayers;
import glicodeDDD.glico.player.Player;
import glicodeDDD.glico.player.WinOutPlayers;

public class GlicoGame {

	private Scanner scan;

	private Point gamePoint;

	private WinOutPlayers winOutPlayers;

	private EntryPlayers entryPlayers;

	public GlicoGame() {
		this.scan = new Scanner(System.in);
		this.winOutPlayers = new WinOutPlayers();

		createPlayers();
		setGamePoint();
	}

	public void start() {
		while (!this.entryPlayers.isLastOne()) {

			this.entryPlayers.nextMoves(this.scan);

			EntryPlayers winners = judgeWinners(this.entryPlayers);

			if (Objects.isNull(winners)) {
				continue;
			}

			winners.getPoint();

			WinOutPlayers winOutPlayers = this.entryPlayers.winOutIfReached(this.gamePoint);
			this.winOutPlayers.addAll(winOutPlayers);
			this.entryPlayers.winOut(winOutPlayers);
		}

		announcementOfResults();
	}

	private void announcementOfWinner(EntryPlayers winners) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	private void setGamePoint() {
		System.out.println("何ポイント先取にしますか。数字で入力してください。");

		this.gamePoint = new Point(scan.nextInt());
	}

	private void createPlayers() {
		List<Player> players = new ArrayList<>();

		System.out.println("プレーヤー数を入力してください。数字で入力してください。");
		int numberOfPlayers = scan.nextInt();

		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(Player.createPlayer("Player" + i + 1));
		}

		System.out.println("コンピュータ数を入力してください。数字で入力してください。");
		int numberOfComputer = scan.nextInt();

		for (int i = 0; i < numberOfComputer; i++) {
			players.add(Player.createComputer("Computer" + i + 1));
		}

		this.entryPlayers = EntryPlayers.entry(players);
	}

	private EntryPlayers judgeWinners(EntryPlayers entryPlayers) {
		Hands hands = entryPlayers.everyOneHands();

		if (isDrawed(hands)) {
			System.out.println("あいこです。");
			return null;
		}
		Hand hand = hands.strongerHand();

		return entryPlayers.hasSameStuits(hand);
	}

	private boolean isDrawed(Hands hands) {
		if (hasAllSuits(hands)) {
			return true;
		}
		if (hasOnlyOneSuits(hands)) {
			return true;
		}
		return false;
	}


	public boolean hasAllSuits(Hands hands) {
		return hands.containsAll(Arrays.asList(Hand.values()));
	}

	public boolean hasOnlyOneSuits(Hands hands) {
		Hand firstOneHand = hands.firstOne();
		return hands.hasOnlyOneSuits(firstOneHand);
	}

	private void announcementOfResults() {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void announcementOfMoves() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
