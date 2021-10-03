package qdo.kata;

import java.util.List;

public class Player {

	private final String name;
	private final List<Card> hand;
	private PokerHand rank;
	private Card winningCard;

	public Player(String name, List<Card> hand) {
		this.name = name;
		this.hand = hand;
		this.hand.sort(Enum::compareTo);
	}

	public String name() {
		return name;
	}

	public List<Card> hand() {
		return hand;
	}

	public Player setRank(String rankName){
		this.rank = PokerHand.valueOf(rankName);
		return this;
	}

	public Player processRanking(){
		if(rank == null)
			PokerHand.PAIR.testPlayerHand(this);
		else if(rank == null)
			PokerHand.HIGH_CARD.testPlayerHand(this);
		return this;
	}

	public PokerHand rank() {
		return rank;
	}

	public Player setWinningCard(Card card) {
		this.winningCard = card;
		return this;
	}

	public Card winningCard() {
		return winningCard;
	}
}
