package qdo.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CardTest {

	@Test
	public void shouldCreateACard(){
		assertThat(Card.from("2C")).isInstanceOf(Card.class);
		assertThat(Card.from("2c")).isInstanceOf(Card.class);
	}

	@Test
	public void shouldThrowIllegalArgumentException(){
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from(""));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("2"));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("C"));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("2CS"));
	}
}
