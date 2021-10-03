package qdo.kata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
	private static final Pattern cardsPattern = Pattern.compile("\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*");

	@Test
	public void shouldReturnHighestCard(){
		assertThat(new Player("Black", createCards("2H 2C 5C 6H 4H")).rank()).isEqualByComparingTo(PokerHand.HIGH_CARD);
	}

	private List<Card> createCards(String data){
		Matcher matcher = cardsPattern.matcher(data);
		return Arrays.asList(Card.from(matcher.group(1)), Card.from(matcher.group(2)),
			Card.from(matcher.group(3)), Card.from(matcher.group(4)), Card.from(matcher.group(5)));
	}
}
