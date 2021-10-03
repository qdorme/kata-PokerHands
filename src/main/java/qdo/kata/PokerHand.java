package qdo.kata;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum PokerHand {
	HIGH_CARD(player->{player.setRank("HIGH_CARD").setWinningCard(player.hand().get(4));}),
	PAIR(player->{
		List<Map.Entry<Integer, List<Card>>> pairedCards =
				player.hand().stream().collect(Collectors.groupingBy(Card::value))
						.entrySet().stream().filter(group -> group.getValue().size() == 2)
						.collect(Collectors.toList());
		if(!pairedCards.isEmpty() && pairedCards.get(0).getValue().size() == 2){
			player.setRank("PAIR").setWinningCard(pairedCards.get(0).getValue().get(0));
		}
	}),
	TWO_PAIR(player->{})
	;

	private RankingHands<Player> rankingHands;

	PokerHand(RankingHands<Player> rankingHands){
		this.rankingHands = rankingHands;
	}

	public void testPlayerHand(Player player){
		rankingHands.apply(player);
	}
}
