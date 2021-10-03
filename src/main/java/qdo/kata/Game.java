package qdo.kata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
	private static final Pattern VALID_SETTINGS = Pattern.compile(
			"\\s*(\\w+)\\s*:\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w+)\\s*:\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*(\\w{2})\\s*");

	public static Game from(String dataEntries) {
		Matcher settingsEntries = VALID_SETTINGS.matcher(dataEntries);
		if (!settingsEntries.matches())
			throw new IllegalArgumentException("Data provided are not well setted");

		return null;
	}
}
