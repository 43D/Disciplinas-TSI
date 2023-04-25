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
	@Override
	public String encode(String text) {
		String encodeText = "";
		text = text.replaceAll(" ", String.valueOf(SPACE));

		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			try {
				encodeText += map.encode(letter);
			} catch (Exception e) {
				encodeText += INVALID_CHAR;
			}
			encodeText+= MORSE_SEPARATOR;
		}

		return encodeText;
	}
}