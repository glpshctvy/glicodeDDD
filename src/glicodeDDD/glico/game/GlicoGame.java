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
import glicodeDDD.glico.player.WinOutPlayer;
import glicodeDDD.glico.player.WinOutPlayers;

public class GlicoGame {

	private Scanner scan;

	private Point gamePoint;

	private WinOutPlayers winOutPlayers;

	private EntryPlayers entryPlayers;

	/**
	 * コンストラクタ<br>
	 * グリコを開始する準備をする
	 */
	public GlicoGame() {
		this.scan = new Scanner(System.in);

		createPlayers();
		setGamePoint();
	}

	/**
	 * グリコをスタートする。<br> 
	 * プレーヤ－が最後の一人になるまでジャンケンを続け、最後の一人になったらグリコを終了し、結果発表をする。
	 */
	public void start() {
		while (!this.entryPlayers.isLastOne()) {

			EntryPlayers winners = playJanken();

			if(noWinner(winners)) {
				continue;
			}

			announcementOfWinner(winners);

			winners.getWinPoint();

			winOutIfReachedGamePoint(winners);
		};

		announcementOfResults();
	}
	
	private EntryPlayers playJanken() {
		playersMoveNext();

		return judgeWinner();

	}

	private void playersMoveNext() {
		this.entryPlayers.nextMoves(this.scan);
	}

	private void winOutIfReachedGamePoint(EntryPlayers winners) {
		WinOutPlayers winOutPlayers = winners.winOutIfReached(this.gamePoint);

		if(noWinOut(winOutPlayers)) {
			return;
		}

		winOutGame(winOutPlayers);
	}

	private void winOutGame(WinOutPlayers winOutPlayers) {
		this.winOutPlayers.addAll(winOutPlayers);
		this.entryPlayers.exit(winOutPlayers);
	}

	private boolean noWinOut(WinOutPlayers winOutPlayers) {
		return Objects.isNull(winOutPlayers);
	}

	private boolean noWinner(EntryPlayers winners) {
		return Objects.isNull(winners);
	}

	private void setGamePoint() {
		System.out.println("何ポイント先取にしますか。数字で入力してください。");
		this.gamePoint = new Point(scan.nextInt());
	}

	/**
	 * プレーヤーを作成する。
	 */
	private void createPlayers() {
		List<Player> players = new ArrayList<>();

		players.addAll(createPlayUsers());
		players.addAll(createComputers());
		this.entryPlayers = EntryPlayers.entry(players);

		this.winOutPlayers = new WinOutPlayers();
	}

	/**
	 * 参加人数分プレーヤーを作成する。
	 * @return 参加プレーヤー
	 */
	private List<Player> createPlayUsers() {
		System.out.println("プレーユーザー数を入力してください。数字で入力してください。");
		int numberOfPlayUser = scan.nextInt();

		List<Player> players = new ArrayList<>();
		for (int i = 0; i < numberOfPlayUser; i++) {
			players.add(Player.createPlayer("Player" + (i + 1)));
		}
		return players;
	}

	/**
	 * コンピュータを作成する。
	 * @return コンピュータ
	 */
	private List<Player> createComputers() {
		System.out.println("コンピュータ数を入力してください。数字で入力してください。");
		int numberOfComputer = scan.nextInt();

		List<Player> players = new ArrayList<>();
		for (int i = 0; i < numberOfComputer; i++) {
			players.add(Player.createComputer("Computer" + (i + 1)));
		}
		return players;
	}

	private EntryPlayers judgeWinner() {
		Hands hands = this.entryPlayers.throwEverybodysHands();

		announcementOfEverybodysHands(hands);
	
		if (isDrawed(hands)) {
			System.out.println("あいこです。");
			return null;
		}
		Hand hand = hands.strongerHand();

		return this.entryPlayers.hasSameStuits(hand);
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
		this.winOutPlayers.add(new WinOutPlayer(this.entryPlayers.ofLastOne()));
		System.out.println(this.winOutPlayers.getResult());
	}

	private void announcementOfWinner(EntryPlayers winners) {
		System.out.println("勝者は" + winners.getNames() + "です。");
	}

	private void announcementOfEverybodysHands(Hands hands) {
		System.out.println(hands.open());
	}
}
