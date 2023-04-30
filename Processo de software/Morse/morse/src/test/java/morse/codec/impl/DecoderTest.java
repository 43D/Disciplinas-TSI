package morse.codec.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import morse.codec.MorseDecoder;

public class DecoderTest {
    @Test
    void shouldReturnEmptyString() {
        MorseDecoder decode = new Decoder(MorseCodecMap.getInstance());

        String morse = null;
        String expected = "";
        String obtained = decode.decode(morse);

        assertEquals(expected, obtained);

        morse = "";
        expected = "";
        obtained = decode.decode(morse);

        assertEquals(expected, obtained);
    }
    
	// ----------------------------------------------------------------------
    @Test
    void shouldReturnTheCorrectMorseDecode(){
        MorseDecoder decode = new Decoder(MorseCodecMap.getInstance());
        
        String morse = ".-";
        String expected = "a";
        String obtained = decode.decode(morse);

        assertEquals(expected, obtained);

        morse = "..--..";
        expected = "?";
        obtained = decode.decode(morse);

        assertEquals(expected, obtained);
    }

    // ----------------------------------------------------------------------
    @Test
    void shouldReturnQuestionMarkForUnknownMorses(){
        MorseDecoder decode = new Decoder(MorseCodecMap.getInstance());
        
        String morse = "---------------";
        String expected = "?";
        String obtained = decode.decode(morse);

        assertEquals(expected, obtained);

        morse = "-.-.-.-.-.-.-.-";
        expected = "?";
        obtained = decode.decode(morse);

        assertEquals(expected, obtained);
    }

    // ----------------------------------------------------------------------
    @Test
    void shouldReturnTheCorrectDecodedWord(){
        MorseDecoder decode = new Decoder(MorseCodecMap.getInstance());

        String morse = ".-,-...,.-,-.-.,.-,-..-,..";
        String expected = "abacaxi";
        String obtained = decode.decode(morse);

        assertEquals(expected, obtained);

        morse = ".-,-...,.-,-----------------,.-,-..-,..";
        expected = "aba?axi";
        obtained = decode.decode(morse);

        assertEquals(expected, obtained);

        morse = ".----,..---,...--,....-,.....,-....,--...,---..,----.,-----";
        expected = "1234567890";
        obtained = decode.decode(morse);

        assertEquals(expected, obtained);
    }
    
	// ----------------------------------------------------------------------
    @Test
    void shouldReturnTheCorrectDecodedText(){
        MorseDecoder decode = new Decoder(MorseCodecMap.getInstance());
        
        String morse = ".-,-...,.-,-.-.,.-,-..-,.., ,-.-.,---,--, ,.-..,..,--,.-,---";
        String expected = "abacaxi com limao";
        String obtained = decode.decode(morse);

        assertEquals(expected, obtained);
        
        morse = ".-,-...,.-,-.-.,.-,-..-,.., ,-.-.,---,--, ,.-..,..,--,.-,---";
        morse += "\n";
        morse += "--.,.,.-..,---, ,., ,.--,..,...,-.-,.,-.--";
        expected = "abacaxi com limao\ngelo e wiskey";
        obtained = decode.decode(morse);

        assertEquals(expected, obtained);
    }
}
