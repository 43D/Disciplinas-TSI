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

	private String encodeLine(String line) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < line.length(); i++) {
			char letter = line.charAt(i);
			try {
				sb.append(map.encode(letter));
			} catch (Exception e) {
				sb.append((letter == SPACE) ? SPACE : UNKNOWN);
			}
			if (i != line.length() - 1)
				sb.append(MORSE_SEPARATOR);
		}
		return sb.toString();
	}

	// ----------------------------------------------------------------------
	@Override
	public String encode(String text) {
		if (text == null || "".equals(text))
			return "";
		String encodeText = "";
		text = text.toLowerCase();

		String[] lines = text.split("\n");
		for (String line : lines) {
			encodeText += encodeLine(line);
			if (lines.length > 1)
				encodeText += "\n";
		}

		return encodeText;
	}
}