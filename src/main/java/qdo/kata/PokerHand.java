package qdo.kata;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum PokerHand {
	HIGH_CARD(player -> {
		player.setRank("HIGH_CARD").setWinningCard(player.hand().get(4));
	}),
	PAIR(player -> {
		List<Map.Entry<Integer, List<Card>>> pairedCards = player.hand().stream().collect(Collectors.groupingBy(Card::value)).entrySet().stream().filter(
				group -> group.getValue().size() == 2).collect(Collectors.toList());
		if (pairedCards.size() == 1) {
			player.setRank("PAIR").setWinningCard(pairedCards.get(0).getValue().get(0));
		}
	}),
	TWO_PAIR(player -> {
		List<Map.Entry<Integer, List<Card>>> pairedCards = player.hand().stream().collect(Collectors.groupingBy(Card::value)).entrySet().stream().filter(
				group -> group.getValue().size() == 2).collect(Collectors.toList());
		if (pairedCards.size() == 2) {
			player.setRank("TWO_PAIR").setWinningCard(pairedCards.get(0).getValue().get(0).compareTo(pairedCards.get(1).getValue().get(0)) == 1 ?
					pairedCards.get(0).getValue().get(0) :
					pairedCards.get(1).getValue().get(0));
		}
	}),
	THREE_OF_A_KIND(player->{
		List<Map.Entry<Integer, List<Card>>> pairedCards = player.hand().stream().collect(Collectors.groupingBy(Card::value)).entrySet().stream().filter(
				group -> group.getValue().size() == 3).collect(Collectors.toList());
		if (pairedCards.size() == 1) {
			player.setRank("THREE_OF_A_KIND").setWinningCard(pairedCards.get(0).getValue().get(0));
		}
	}),
	STRAIGHT(player->{
		if(	IntStream.range(0, 4).map(index -> player.hand().get(index + 1).value() - player.hand().get(index).value()).distinct().sum() == 1){
			player.setRank("STRAIGHT").setWinningCard(player.hand().get(4));
		}
	}),
	FLUSH(player->{
		if(player.hand().stream().collect(Collectors.groupingBy(Card::suit)).size() == 1){
			player.setRank("FLUSH").setWinningCard(player.hand().get(4));
		}
	}),
	FULL_HOUSE(player->{
		Set<Map.Entry<Integer, List<Card>>> pairedCards = player.hand().stream().collect(Collectors.groupingBy(Card::value)).entrySet();
		if (pairedCards.stream().filter(group -> group.getValue().size() == 2).count() == 1 && pairedCards.stream().filter(group -> group.getValue().size() == 3)
				.count() == 1){
			player.setRank("FULL_HOUSE").setWinningCard( pairedCards.stream().filter(group -> group.getValue().size() == 3).findFirst().get().getValue().get(0));
		}
	}),
	FOUR_OF_A_KIND(player->{
		List<Map.Entry<Integer, List<Card>>> pairedCards = player.hand().stream().collect(Collectors.groupingBy(Card::value)).entrySet().stream().filter(
				group -> group.getValue().size() == 4).collect(Collectors.toList());
		if (pairedCards.size() == 1) {
			player.setRank("FOUR_OF_A_KIND").setWinningCard(pairedCards.get(0).getValue().get(0));
		}
	});

	private RankingHands<Player> rankingHands;

	PokerHand(RankingHands<Player> rankingHands) {
		this.rankingHands = rankingHands;
	}

	public void testPlayerHand(Player player) {
		rankingHands.apply(player);
	}
}
