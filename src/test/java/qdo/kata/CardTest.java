package qdo.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CardTest {

	@Test
	public void shouldCreateACard(){
		assertThat(Card.from("2C")).isEqualByComparingTo(Card.C2);
		assertThat(Card.from("2c")).isEqualByComparingTo(Card.C2);
		assertThat(Card.from("2S")).isEqualByComparingTo(Card.S2);
		assertThat(Card.from("2H")).isEqualByComparingTo(Card.H2);
		assertThat(Card.from("2D")).isEqualByComparingTo(Card.D2);
		assertThat(Card.from("3S")).isEqualByComparingTo(Card.S3);
		assertThat(Card.from("3H")).isEqualByComparingTo(Card.H3);
		assertThat(Card.from("3D")).isEqualByComparingTo(Card.D3);
		assertThat(Card.from("3C")).isEqualByComparingTo(Card.C3);
		assertThat(Card.from("4S")).isEqualByComparingTo(Card.S4);
		assertThat(Card.from("4H")).isEqualByComparingTo(Card.H4);
		assertThat(Card.from("4D")).isEqualByComparingTo(Card.D4);
		assertThat(Card.from("4C")).isEqualByComparingTo(Card.C4);
		assertThat(Card.from("5S")).isEqualByComparingTo(Card.S5);
		assertThat(Card.from("5H")).isEqualByComparingTo(Card.H5);
		assertThat(Card.from("5D")).isEqualByComparingTo(Card.D5);
		assertThat(Card.from("5C")).isEqualByComparingTo(Card.C5);
		assertThat(Card.from("6S")).isEqualByComparingTo(Card.S6);
		assertThat(Card.from("6H")).isEqualByComparingTo(Card.H6);
		assertThat(Card.from("6D")).isEqualByComparingTo(Card.D6);
		assertThat(Card.from("6C")).isEqualByComparingTo(Card.C6);
		assertThat(Card.from("7S")).isEqualByComparingTo(Card.S7);
		assertThat(Card.from("7H")).isEqualByComparingTo(Card.H7);
		assertThat(Card.from("7D")).isEqualByComparingTo(Card.D7);
		assertThat(Card.from("7C")).isEqualByComparingTo(Card.C7);
		assertThat(Card.from("8S")).isEqualByComparingTo(Card.S8);
		assertThat(Card.from("8H")).isEqualByComparingTo(Card.H8);
		assertThat(Card.from("8D")).isEqualByComparingTo(Card.D8);
		assertThat(Card.from("8C")).isEqualByComparingTo(Card.C8);
		assertThat(Card.from("9S")).isEqualByComparingTo(Card.S9);
		assertThat(Card.from("9H")).isEqualByComparingTo(Card.H9);
		assertThat(Card.from("9D")).isEqualByComparingTo(Card.D9);
		assertThat(Card.from("9C")).isEqualByComparingTo(Card.C9);
		assertThat(Card.from("TS")).isEqualByComparingTo(Card.ST);
		assertThat(Card.from("TH")).isEqualByComparingTo(Card.HT);
		assertThat(Card.from("TD")).isEqualByComparingTo(Card.DT);
		assertThat(Card.from("TC")).isEqualByComparingTo(Card.CT);
		assertThat(Card.from("JS")).isEqualByComparingTo(Card.SJ);
		assertThat(Card.from("JH")).isEqualByComparingTo(Card.HJ);
		assertThat(Card.from("JD")).isEqualByComparingTo(Card.DJ);
		assertThat(Card.from("JC")).isEqualByComparingTo(Card.CJ);
		assertThat(Card.from("QS")).isEqualByComparingTo(Card.SQ);
		assertThat(Card.from("QH")).isEqualByComparingTo(Card.HQ);
		assertThat(Card.from("QD")).isEqualByComparingTo(Card.DQ);
		assertThat(Card.from("QC")).isEqualByComparingTo(Card.CQ);
		assertThat(Card.from("KS")).isEqualByComparingTo(Card.SK);
		assertThat(Card.from("KH")).isEqualByComparingTo(Card.HK);
		assertThat(Card.from("KD")).isEqualByComparingTo(Card.DK);
		assertThat(Card.from("KC")).isEqualByComparingTo(Card.CK);
		assertThat(Card.from("AS")).isEqualByComparingTo(Card.SA);
		assertThat(Card.from("AH")).isEqualByComparingTo(Card.HA);
		assertThat(Card.from("AD")).isEqualByComparingTo(Card.DA);
		assertThat(Card.from("AC")).isEqualByComparingTo(Card.CA);
	}

	@Test
	public void shouldThrowIllegalArgumentException(){
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from(""));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("2"));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("C"));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Card.from("2CS"));
	}
}
