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
		assertThat(new Player("Black", createCards("2H 3C 7C 6H 4H")).processRanking().rank()).isEqualByComparingTo(PokerHand.HIGH_CARD);
		assertThat(new Player("Black", createCards("2H 3C 7C 6H 4H")).processRanking().winningCard()).isEqualByComparingTo(Card.C7);
	}
	@Test
	public void shouldReturnPairRanking(){
		assertThat(new Player("Black", createCards("2H 2C 5C 6H 4H")).processRanking().rank()).isEqualByComparingTo(PokerHand.PAIR);
		assertThat(new Player("Black", createCards("2H 2C 5C 6H 4H")).processRanking().winningCard().value()).isEqualTo(2);
	}

	@Test
	public void shouldReturnTwoPairRanking(){
		assertThat(new Player("Black", createCards("2H 2C 5C 5H 4H")).processRanking().rank()).isEqualByComparingTo(PokerHand.TWO_PAIR);
		assertThat(new Player("Black", createCards("2H 2C 5C 5H 4H")).processRanking().winningCard().value()).isEqualTo(5);
	}

	@Test
	public void shouldReturnThreeOfAKindRanking(){
		assertThat(new Player("Black", createCards("2H 2C 5C 5H 2S")).processRanking().rank()).isEqualByComparingTo(PokerHand.THREE_OF_A_KIND);
		assertThat(new Player("Black", createCards("2H 2C 5C 5H 2S")).processRanking().winningCard().value()).isEqualTo(2);
	}

	@Test
	public void shouldReturnStraightRanking(){
		assertThat(new Player("Black", createCards("3H 4C 5C 6H 2S")).processRanking().rank()).isEqualByComparingTo(PokerHand.STRAIGHT);
		assertThat(new Player("Black", createCards("3H 4C 5C 6H 2S")).processRanking().winningCard().value()).isEqualTo(6);
	}

	private List<Card> createCards(String data){
		Matcher matcher = cardsPattern.matcher(data);
		if(matcher.matches())
			return Arrays.asList(Card.from(matcher.group(1)), Card.from(matcher.group(2)),
				Card.from(matcher.group(3)), Card.from(matcher.group(4)), Card.from(matcher.group(5)));
		else return null;
	}
}
