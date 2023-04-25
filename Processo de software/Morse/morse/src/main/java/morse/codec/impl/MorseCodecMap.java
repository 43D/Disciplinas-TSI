package morse.codec.impl;

import static java.util.Map.entry;

import java.util.Map;

public class MorseCodecMap implements MorseEncodeMap, MorseDecodeMap {
	private static MorseCodecMap singleton;

	// -----------------------------
	private MorseCodecMap() {
		singleton = this;
	}

	// -----------------------------
	public static final MorseCodecMap getInstance() {
		if (singleton == null)
			new MorseCodecMap();

		return singleton;
	}

	// ----------------------------------------------------------------------------------
	private final Map<String, String> encoderMap = Map.ofEntries(
			entry("a", ".-"), entry("b", "-..."), entry("c", "-.-."),
			entry("d", "-.."), entry("e", "."), entry("f", "..-."),
			entry("g", "--."), entry("h", "...."), entry("i", ".."),
			entry("j", ".---"), entry("k", "-.-"), entry("l", ".-.."),
			entry("m", "--"), entry("n", "-."), entry("o", "---"),
			entry("p", ".--."), entry("q", "--.-"), entry("r", ".-."),
			entry("s", "..."), entry("t", "-"), entry("u", "..-"),
			entry("v", "...-"), entry("w", ".--"), entry("x", "-..-"),
			entry("y", "-.--"), entry("z", "--.."),

			entry("1", ".----"), entry("2", "..---"), entry("3", "...--"),
			entry("4", "....-"), entry("5", "....."), entry("6", "-...."),
			entry("7", "--..."), entry("8", "---.."), entry("9", "----."),
			entry("0", "-----"),

			entry(".", ".-.-.-"), entry(",", "--..--"), entry("?", "..--.."),
			entry("!", "-.-.--"), entry("\'", ".----."), entry("\"", ".-..-."),
			entry("(", "-.--."), entry(")", "-.--.-"), entry("&", ".-..."),
			entry(":", "---..."), entry(";", "-.-.-."), entry("/", "-..-."),
			entry("_", "..--.-"), entry("=", "-...-"), entry("+", ".-.-."),
			entry("-", "-....-"), entry("$", "...-..-"), entry("@", ".--.-."),

			entry("SOS", "...---..."),
			entry("NEW_LINE", ".-.-"),
			entry("ATTENTION", "-.-.-"),
			entry("ERROR", "........"),
			entry("BREAK", "-... -.-"),
			entry("CLOSING", "-.-. .-.."),
			entry("UNDERSTOOD", "...-."));

	// ---------------------------------------------------------------------------
	private final Map<String, String> decoderMap = Map.ofEntries(
			entry(".-", "a"), entry("-...", "b"), entry("-.-.", "c"),
			entry("-..", "d"), entry(".", "e"), entry("..-.", "f"),
			entry("--.", "g"), entry("....", "h"), entry("..", "i"),
			entry(".---", "j"), entry("-.-", "k"), entry(".-..", "l"),
			entry("--", "m"), entry("-.", "n"), entry("---", "o"),
			entry(".--.", "p"), entry("--.-", "q"), entry(".-.", "r"),
			entry("...", "s"), entry("-", "t"), entry("..-", "u"),
			entry("...-", "v"), entry(".--", "w"), entry("-..-", "x"),
			entry("-.--", "y"), entry("--..", "z"),
			entry(".----", "1"), entry("..---", "2"), entry("...--", "3"),
			entry("....-", "4"), entry(".....", "5"), entry("-....", "6"),
			entry("--...", "7"), entry("---..", "8"), entry("----.", "9"),
			entry("-----", "0"),

			entry(".-.-.-", "."), entry("--..--", ","), entry("..--..", "?"),
			entry("-.-.--", "!"), entry(".----.", "\'"), entry(".-..-.", "\""),
			entry("-.--.", "("), entry("-.--.-", ")"), entry(".-...", "&"),
			entry("---...", ":"), entry("-.-.-.", ";"), entry("-..-.", "/"),
			entry("..--.-", "_"), entry("-...-", "="), entry(".-.-.", "+"),
			entry("-....-", "-"), entry("...-..-", "$"), entry(".--.-.", "@"),

			entry("...---...", "SOS"),
			entry(".-.-", "NEW_LINE"),
			entry("-.-.-", "ATTENTION"),
			entry("........", "ERROR"),
			entry("-... -.-", "BREAK"),
			entry("-.-. .-..", "CLOSING"),
			entry("...-.", "UNDERSTOOD"));

	public final String SOS = "...---...";
	public final String NEW_LINE = ".-.-";
	public final String ATTENTION = "-.-.-";
	public final String ERROR = "........";
	public final String BREAK = "-... -.-";
	public final String CLOSING = "-.-. .-..";
	public final String UNDERSTOOD = "...-.";

	// ---------------------------------------------------------------------------
	@Override
	public String encode(char letter) throws Exception {
		String value = encoderMap.get("" + letter);
		if (value == null)
			throw new Exception("Invalid letter: '" + letter + "'");

		return value;
	}

	@Override
	public String decode(String morseCode) throws Exception {
		String value = decoderMap.get(morseCode);
		if (value == null)
			throw new Exception("Invalid morse: '" + morseCode + "'");

		return value;
	}

}
