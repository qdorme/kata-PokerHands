package qdo.kata;

import java.util.Locale;

public enum Card {
	C2(2, 'C');

	private final Integer value;
	private final Character suit;

	Card(Integer value, Character suit) {
		this.value = value;
		this.suit = suit;
	}

	public static Card from(String card) {
		return Card.valueOf(new StringBuilder(card).reverse().toString().toUpperCase(Locale.ENGLISH));
	}

	public Integer value() {
		return value;
	}

	public Character suit() {
		return suit;
	}
}
