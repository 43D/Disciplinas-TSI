package morse.codec.impl;

import morse.codec.MorseEncoder;

//---------------------------------------------------------------------------
public class Encoder extends AbstractMorseCodec
implements MorseEncoder
{
	private MorseDecodeMap map;

	//----------------------------------------------------------------------
	public Encoder(final MorseDecodeMap map)
	{
		super();
		this.map = map;
	}
	
	//----------------------------------------------------------------------
	@Override
	public String encode(String text) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}