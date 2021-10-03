package qdo.kata;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

	private static final Pattern VALID_SETTINGS = Pattern.compile(
			"\\s*(\\w+)\\s*:\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w+)\\s*:\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*");

	private final List<Player> players;

	private Game(List<Player> players){
		this.players=players;
	}

	public static Game from(String dataEntries) {
		Matcher settingsEntries = VALID_SETTINGS.matcher(dataEntries);
		if (!settingsEntries.matches())
			throw new IllegalArgumentException("Data provided are not well setted");

		List<Card> firstPlayerCards = Arrays.asList(Card.from(settingsEntries.group(2)), Card.from(settingsEntries.group(3)),
				Card.from(settingsEntries.group(4)), Card.from(settingsEntries.group(5)), Card.from(settingsEntries.group(6)));
		List<Card> secondPlayerCards = Arrays.asList(Card.from(settingsEntries.group(8)), Card.from(settingsEntries.group(9)),
				Card.from(settingsEntries.group(10)), Card.from(settingsEntries.group(11)), Card.from(settingsEntries.group(12)));
		verifyThatACardIsPickedOnlyOnce(firstPlayerCards, secondPlayerCards);
		return new Game(Arrays.asList(new Player(settingsEntries.group(1),firstPlayerCards),new Player(settingsEntries.group(7),secondPlayerCards)));
	}



	private static void verifyThatACardIsPickedOnlyOnce(List<Card> firstPlayerCards, List<Card> secondPlayerCards) {
		if(Stream.concat(firstPlayerCards.stream(), secondPlayerCards.stream()).collect(Collectors.groupingBy(Card::name))
				.entrySet().stream().filter(set->set.getValue().size() != 1).count() > 0)
			throw new IllegalArgumentException("A card can not be picked twice");
	}

	public List<Player> players() {
		return players;
	}

	public String processRanking() {
		players.forEach(player -> player.processRanking());
		if(players.get(0).rank().compareTo(players.get(1).rank()) == 0
				&& players.get(0).winningCard().value() == players.get(1).winningCard().value())
			return "Tie.";
		Player winner = players.get(0).rank().compareTo(players.get(1).rank()) > 0 ? players.get(0) : players.get(1);
		if(winner.secondCard() == null)
			return String.format("%s wins. - with %s: %s",winner.name(),winner.rank().littleName(),winner.winningCard().description());
		else
			return String.format("%s wins. - with %s: %s over %S",winner.name(),winner.rank().littleName(),winner.winningCard().description(),winner.secondCard().description());
	}
}
