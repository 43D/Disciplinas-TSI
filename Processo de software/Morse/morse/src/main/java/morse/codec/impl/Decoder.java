package morse.codec.impl;

import morse.codec.MorseDecoder;

//---------------------------------------------------------------------------	 
public class Decoder extends AbstractMorseCodec
implements MorseDecoder
{	
	private MorseDecodeMap map;

	//----------------------------------------------------------------------
	public Decoder(final MorseDecodeMap map)
	{
		super();
		this.map = map;
	}

	//----------------------------------------------------------------------
	@Override
	public String decode(String text) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}