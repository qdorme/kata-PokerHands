package qdo.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

	@Test
	public void shouldCreateACard(){
		assertThat(Card.from("2C")).isInstanceOf(Card.class);
	}
}
