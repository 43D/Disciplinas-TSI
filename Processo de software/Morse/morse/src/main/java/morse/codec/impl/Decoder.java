package morse.codec.impl;

import morse.codec.MorseDecoder;

//---------------------------------------------------------------------------	 
public class Decoder extends AbstractMorseCodec
		implements MorseDecoder {
	private MorseDecodeMap map;

	// ----------------------------------------------------------------------
	public Decoder(final MorseDecodeMap map) {
		super();
		this.map = map;
	}

	// ----------------------------------------------------------------------
	@Override
	public String decode(String text) {
		String decodeText = "";
		final String[] morseArray = text.split(String.valueOf(MORSE_SEPARATOR));

		for (String morse : morseArray)
			try {
				decodeText += map.decode(morse);
			} catch (Exception e) {
				decodeText += INVALID_CHAR;
			}

		decodeText = decodeText.replaceAll(String.valueOf(SPACE), " ");

		return decodeText;
	}
}