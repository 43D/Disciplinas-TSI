package morse.codec.impl;

public abstract class AbstractMorseCodec 
{
	public final char MORSE_SEPARATOR = ',';
	public final char SPACE = '/';
	
	protected final MorseCodecMap map;
	
	//-----------------------------------------------------
	protected AbstractMorseCodec(final MorseCodecMap map)
	{
		this.map = map;
	}

    public AbstractMorseCodec() {
    }
}