package morse.codec;

import morse.codec.impl.Decoder;
import morse.codec.impl.Encoder;
import morse.codec.impl.MorseCodecMap;

public class MorseCodecFactory 
{
	//-------------------------------------------------
	private MorseCodecFactory() 
	{
		/*Nothing for now*/
	}
	
	//-------------------------------------------------
	public static final 
	MorseEncoder createEncoder()
	{
		return new Encoder(MorseCodecMap.getInstance());
	}
	
	//-------------------------------------------------
	public static final 
	MorseDecoder createDecoder()
	{
		return new Decoder(MorseCodecMap.getInstance());
	}
}
