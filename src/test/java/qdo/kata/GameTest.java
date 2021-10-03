package qdo.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameTest {

	@Test
	public void shouldThrowIllegalArgumentException(){
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Game.from("Black: 3D 5S 9C KD : 2H 3H 4S 8C AH"));
	}
}