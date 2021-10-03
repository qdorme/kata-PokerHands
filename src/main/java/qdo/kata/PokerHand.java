package qdo.kata;

public enum PokerHand {
	HIGH_CARD(player->{player.setRank("HIGH_CARD").setWinningCard(player.hand().get(4));});

	private RankingHands<Player> rankingHands;

	PokerHand(RankingHands<Player> rankingHands){
		this.rankingHands = rankingHands;
	}

	public void testPlayerHand(Player player){
		rankingHands.apply(player);
	}
}
