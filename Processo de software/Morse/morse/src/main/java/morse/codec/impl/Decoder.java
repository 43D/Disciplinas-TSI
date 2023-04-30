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
	private String decodeWord(String word) {
		StringBuffer sbDecodeWord = new StringBuffer();
		final String[] morseArray = word.split(String.valueOf(MORSE_SEPARATOR));

		for (String morse : morseArray)
			try {
				if (!morse.equals(EMPTY_STRING))
					sbDecodeWord.append(map.decode(morse));
			} catch (Exception e) {
				sbDecodeWord.append(UNKNOWN);
			}

		String decodeWord = sbDecodeWord.toString();

		return decodeWord;
	}

	// ----------------------------------------------------------------------
	private String decodeLine(String line) {
		StringBuffer sbDecodeLine = new StringBuffer();
		final String[] morseWordArray = line.split(String.valueOf(SPACE));

		for (String morseWord : morseWordArray) {
			sbDecodeLine.append(decodeWord(morseWord));
			sbDecodeLine.append(SPACE);
		}

		String decodeLine = removeLastCharOf(sbDecodeLine.toString());
		return decodeLine;
	}

	// ----------------------------------------------------------------------
	private String decodeText(String text) {
		StringBuffer sbDecodeText = new StringBuffer();
		String[] lines = text.split(BREAK_LINE);

		for (String line : lines) {
			sbDecodeText.append(decodeLine(line));
			sbDecodeText.append(BREAK_LINE);
		}

		String decodeText = removeLastCharOf(sbDecodeText.toString());

		return decodeText;
	}

	// ----------------------------------------------------------------------
	@Override
	public String decode(String text) {
		if (text == null || EMPTY_STRING.equals(text))
			return EMPTY_STRING;

		String decodeText = decodeText(text);

		return decodeText;
	}

}