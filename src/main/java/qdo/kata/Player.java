package qdo.kata;

import java.util.List;

public class Player {

	private final String name;
	private final List<Card> hand;

	public Player(String name, List<Card> hand) {
		this.name = name;
		this.hand = hand;
	}

	public String name() {
		return name;
	}

	public List<Card> hand() {
		return hand;
	}

	public PokerHand rank() {
		return null;
	}
}
