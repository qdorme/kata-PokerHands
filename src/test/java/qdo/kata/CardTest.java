package qdo.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CardTest {

	@Test
	public void shouldCreateACard(){
		assertThat(Card.from("2C")).isInstanceOf(Card.class);
		assertThat(Card.from("2c")).isInstanceOf(Card.class);
		assertThat(Card.from("2S")).isInstanceOf(Card.class);
		assertThat(Card.from("2H")).isInstanceOf(Card.class);
		assertThat(Card.from("2D")).isInstanceOf(Card.class);
		assertThat(Card.from("3S")).isInstanceOf(Card.class);
		assertThat(Card.from("3H")).isInstanceOf(Card.class);
		assertThat(Card.from("3D")).isInstanceOf(Card.class);
		assertThat(Card.from("3C")).isInstanceOf(Card.class);
		assertThat(Card.from("4S")).isInstanceOf(Card.class);
		assertThat(Card.from("4H")).isInstanceOf(Card.class);
		assertThat(Card.from("4D")).isInstanceOf(Card.class);
		assertThat(Card.from("4C")).isInstanceOf(Card.class);
		assertThat(Card.from("5S")).isInstanceOf(Card.class);
		assertThat(Card.from("5H")).isInstanceOf(Card.class);
		assertThat(Card.from("5D")).isInstanceOf(Card.class);
		assertThat(Card.from("5C")).isInstanceOf(Card.class);
		assertThat(Card.from("6S")).isInstanceOf(Card.class);
		assertThat(Card.from("6H")).isInstanceOf(Card.class);
		assertThat(Card.from("6D")).isInstanceOf(Card.class);
		assertThat(Card.from("6C")).isInstanceOf(Card.class);
		assertThat(Card.from("7S")).isInstanceOf(Card.class);
		assertThat(Card.from("7H")).isInstanceOf(Card.class);
		assertThat(Card.from("7D")).isInstanceOf(Card.class);
		assertThat(Card.from("7C")).isInstanceOf(Card.class);
		assertThat(Card.from("8S")).isInstanceOf(Card.class);
		assertThat(Card.from("8H")).isInstanceOf(Card.class);
		assertThat(Card.from("8D")).isInstanceOf(Card.class);
		assertThat(Card.from("8C")).isInstanceOf(Card.class);
		assertThat(Card.from("9S")).isInstanceOf(Card.class);
		assertThat(Card.from("9H")).isInstanceOf(Card.class);
		assertThat(Card.from("9D")).isInstanceOf(Card.class);
		assertThat(Card.from("9C")).isInstanceOf(Card.class);
		assertThat(Card.from("TS")).isInstanceOf(Card.class);
		assertThat(Card.from("TH")).isInstanceOf(Card.class);
		assertThat(Card.from("TD")).isInstanceOf(Card.class);
		assertThat(Card.from("TC")).isInstanceOf(Card.class);
		assertThat(Card.from("JS")).isInstanceOf(Card.class);
		assertThat(Card.from("JH")).isInstanceOf(Card.class);
		assertThat(Card.from("JD")).isInstanceOf(Card.class);
		assertThat(Card.from("JC")).isInstanceOf(Card.class);
		assertThat(Card.from("QS")).isInstanceOf(Card.class);
		assertThat(Card.from("QH")).isInstanceOf(Card.class);
		assertThat(Card.from("QD")).isInstanceOf(Card.class);
		assertThat(Card.from("QC")).isInstanceOf(Card.class);
		assertThat(Card.from("KS")).isInstanceOf(Card.class);
		assertThat(Card.from("KH")).isInstanceOf(Card.class);
		assertThat(Card.from("KD")).isInstanceOf(Card.class);
		assertThat(Card.from("KC")).isInstanceOf(Card.class);
		assertThat(Card.from("AS")).isInstanceOf(Card.class);
		assertThat(Card.from("AH")).isInstanceOf(Card.class);
		assertThat(Card.from("AD")).isInstanceOf(Card.class);
		assertThat(Card.from("AC")).isInstanceOf(Card.class);
	}

	@Test
	public void shouldThrowIllegalArgumentException(){
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from(""));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("2"));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("C"));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("2CS"));
	}
}
