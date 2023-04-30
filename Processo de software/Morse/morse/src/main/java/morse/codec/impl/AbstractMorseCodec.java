package morse.codec.impl;

public abstract class AbstractMorseCodec 
{
	public final char MORSE_SEPARATOR = ',';
	public final char SPACE = ' ';
	public final char UNKNOWN = '?';
	public final String BREAK_LINE = "\n";
	public final String EMPTY_STRING = "";
	
	//-----------------------------------------------------
	protected AbstractMorseCodec()
	{
	}

	//-----------------------------------------------------
	protected String removeLastCharOf(String text) {
		return (text == null || text.length() == 0)
				? ""
				: (text.substring(0, text.length() - 1));
	}
}
