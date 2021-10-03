package qdo.kata;

import java.util.Locale;

public enum Card {

	C2(2,'2',"2"),
	S2(2,'2',"2"),
	H2(2,'2',"2"),
	D2(2,'2',"2"),
	S3(3,'3',"3"),
	H3(3,'3',"3"),
	D3(3,'3',"3"),
	C3(3,'3',"3"),
	S4(4,'4',"4"),
	H4(4,'4',"4"),
	D4(4,'4',"4"),
	C4(4,'4',"4"),
	S5(5,'5',"5"),
	H5(5,'5',"5"),
	D5(5,'5',"5"),
	C5(5,'5',"5"),
	S6(6,'6',"6"),
	H6(6,'6',"6"),
	D6(6,'6',"6"),
	C6(6,'6',"6"),
	S7(7,'7',"7"),
	H7(7,'7',"7"),
	D7(7,'7',"7"),
	C7(7,'7',"7"),
	S8(8,'8',"8"),
	H8(8,'8',"8"),
	D8(8,'8',"8"),
	C8(8,'8',"8"),
	S9(9,'9',"9"),
	H9(9,'9',"9"),
	D9(9,'9',"9"),
	C9(9,'9',"9"),
	ST(10,'S',"10"),
	HT(10,'H',"10"),
	DT(10,'D',"10"),
	CT(10,'C',"10"),
	SJ(11,'S',"Jack"),
	HJ(11,'H',"Jack"),
	DJ(11,'D',"Jack"),
	CJ(11,'C',"Jack"),
	SQ(12,'S',"Queen"),
	HQ(12,'H',"Queen"),
	DQ(12,'D',"Queen"),
	CQ(12,'C',"Queen"),
	SK(13,'S',"King"),
	HK(13,'H',"King"),
	DK(13,'D',"King"),
	CK(13,'C',"King"),
	SA(14,'S',"Ace"),
	HA(14,'H',"Ace"),
	DA(14,'D',"Ace"),
	CA(14,'C',"Ace");

	private final Integer value;
	private final Character suit;
	private final String description;

	Card(Integer value, Character suit, String description) {
		this.value = value;
		this.suit = suit;
		this.description = description;
	}

	public static Card from(String card) {
		if(card == null || card.length() != 2)
			throw new IllegalArgumentException();
		return Card.valueOf(new StringBuilder(card).reverse().toString().toUpperCase(Locale.ENGLISH));
	}

	public Integer value() {
		return value;
	}

	public Character suit() {
		return suit;
	}

	public String description() {
		return description;
	}
}
