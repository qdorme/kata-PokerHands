package qdo.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameTest {

	@Test
	public void shouldThrowIllegalArgumentException(){
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Game.from("Black: 3D 5S 9C KD : 2H 3H 4S 8C AH"));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Game.from("Black: 3D 5S 9C KD 2C White : 2C 3H 4S 8C AH"));
	}

	@Test
	public void shouldCreateAGame(){
		assertThat(Game.from("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH")).isInstanceOf(Game.class);
		assertThat(Game.from("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH").players().size()).isEqualTo(2);
	}

	@Test
	public void shouldHaveAWinner(){
		assertThat(Game.from("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH").processRanking()).isEqualTo("White wins. - with high card: Ace");
		assertThat(Game.from("Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S").processRanking()).isEqualTo("Black wins. - with full house: 4 over 2");
		assertThat(Game.from("Black: 2H 3D 5S 4C 6D White: 2C 3H 4S 8C KH").processRanking()).isEqualTo("Black wins. - with straight: 6");
		assertThat(Game.from("Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH").processRanking()).isEqualTo("Tie.");
	}
}
