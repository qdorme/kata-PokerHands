package qdo.kata;

import java.util.List;

public class Player {

	private final String name;
	private final List<Card> hand;
	private PokerHand rank;
	private Card winningCard;
	private Card secondCard;

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
			PokerHand.STRAIGHT_FLUSH.testPlayerHand(this);
		if(rank == null)
			PokerHand.FOUR_OF_A_KIND.testPlayerHand(this);
		if(rank == null)
			PokerHand.FULL_HOUSE.testPlayerHand(this);
		if(rank == null)
			PokerHand.FLUSH.testPlayerHand(this);
		if(rank == null)
			PokerHand.STRAIGHT.testPlayerHand(this);
		if(rank == null)
			PokerHand.THREE_OF_A_KIND.testPlayerHand(this);
		if(rank == null)
			PokerHand.TWO_PAIR.testPlayerHand(this);
		if(rank == null)
			PokerHand.PAIR.testPlayerHand(this);
		if(rank == null)
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

	public Card secondCard() {
		return secondCard;
	}

	public Player setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
		return this;
	}
}
