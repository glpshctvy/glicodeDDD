package glicodeDDD.glico.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import glicodeDDD.glico.game.Point;
import glicodeDDD.glico.game.Rank;
import glicodeDDD.glico.janken.Hand;
import glicodeDDD.glico.janken.Hands;

public class EntryPlayers {

	private List<EntryPlayer> entryPlayers;

	public EntryPlayers(List<EntryPlayer> players) {
		this.entryPlayers = players;
	}

	public boolean isLastOne() {
		return entryPlayers.size() == 1;
	}

	public void nextMoves(Scanner scan) {
		entryPlayers.forEach(player -> player.nextMove(scan));
	}

	public Hands everyOneHands() {
		return new Hands(entryPlayers.stream().map(EntryPlayer::openHand).collect(Collectors.toList()));

	}

	public Hand getAnyOneHand() {
		return this.entryPlayers.get(0).openHand();
	}

	public WinOutPlayers winOutIfReached(Point gamePoint) {
		List<WinOutPlayer> winners = new ArrayList<>();
		for (EntryPlayer player : this.entryPlayers) {
			if (player.isReached(gamePoint)) {
				winners.add(player.winOut());
			}
		}
		Rank.countUp(winners.size());
		return new WinOutPlayers(winners);
	}

	public WinOutPlayers isAbleToIinOutIfReached(Point gamePoint) {
		List<WinOutPlayer> winners = new ArrayList<>();
		for (EntryPlayer player : this.entryPlayers) {
			if (player.isReached(gamePoint)) {
				winners.add(player.winOut());
			}
		}
		Rank.countUp(winners.size());
		return new WinOutPlayers(winners);
	}

	public void getWinPoint() {
		this.entryPlayers.forEach(EntryPlayer::getPoint);
	}

	public EntryPlayers hasSameStuits(Hand winHand) {
		List<EntryPlayer> winners = new ArrayList<>();
		for (EntryPlayer player : this.entryPlayers) {
			if (player.openHand() == winHand) {
				winners.add(player);
			}
		}

		return new EntryPlayers(winners);
	}

	public static EntryPlayers entry(List<Player> players) {
		List<EntryPlayer> entryPlayers = new ArrayList<>();
		for (Player player : players) {
			entryPlayers.add(new EntryPlayer(player));
		}

		return new EntryPlayers(entryPlayers);

	}

	public void winOut(WinOutPlayers winOutPlayers) {
		for (WinOutPlayer player : winOutPlayers.getList()) {
			winOut(player);
		}

	}

	public void winOut(WinOutPlayer winOutPlayer) {
		Iterator<EntryPlayer> iterator = this.entryPlayers.iterator();
		while (iterator.hasNext()) {
			EntryPlayer player = iterator.next();
			if (player.getPlayer().equals(winOutPlayer.getPlayer())) {
				iterator.remove();
			}
		}
	}

	public String getNames() {
		StringJoiner joinner = new StringJoiner(",");
		this.entryPlayers.forEach(p -> joinner.add(p.getPlayer().getPlayerName().value()));
		return joinner.toString();
	}

}
