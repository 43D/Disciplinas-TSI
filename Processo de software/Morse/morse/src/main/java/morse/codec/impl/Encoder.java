package morse.codec.impl;

import morse.codec.MorseEncoder;

//---------------------------------------------------------------------------
public class Encoder extends AbstractMorseCodec
		implements MorseEncoder {
	private MorseEncodeMap map;

	// ----------------------------------------------------------------------
	public Encoder(final MorseEncodeMap map) {
		super();
		this.map = map;
	}

	// ----------------------------------------------------------------------
	private String encodeLine(String line) {
		StringBuffer sbLine = new StringBuffer();
		for (int i = 0; i < line.length(); i++) {
			char letter = line.charAt(i);
			try {
				sbLine.append(map.encode(letter));
			} catch (Exception e) {
				sbLine.append((letter == SPACE) ? SPACE : UNKNOWN);
			}
			sbLine.append(MORSE_SEPARATOR);
		}

		return removeLastCharOf(sbLine.toString());
	}

	// ----------------------------------------------------------------------
	private String encodeText(String text) {
		text = text.toLowerCase();
		StringBuffer sbEncodeText = new StringBuffer();
		String[] lines = text.split(BREAK_LINE);

		for (String line : lines) {
			sbEncodeText.append(encodeLine(line));
			sbEncodeText.append(BREAK_LINE);
		}

		String encodeText = removeLastCharOf(sbEncodeText.toString());

		return encodeText;
	}

	// ----------------------------------------------------------------------
	@Override
	public String encode(String text) {
		if (text == null || EMPTY_STRING.equals(text))
			return EMPTY_STRING;

		String encodeText = encodeText(text);

		return encodeText;
	}
}