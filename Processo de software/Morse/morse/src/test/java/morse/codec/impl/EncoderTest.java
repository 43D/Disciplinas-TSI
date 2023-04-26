package morse.codec.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import morse.codec.MorseEncoder;

public class EncoderTest {
    @Test
    void shouldReturnEmptyString() {
        MorseEncoder encode = new Encoder(MorseCodecMap.getInstance());

        String text = null;
        String expected = "";
        String obtained = encode.encode(text);

        assertEquals(expected, obtained);

        text = "";
        expected = "";
        obtained = encode.encode(text);

        assertEquals(expected, obtained);
    }
    @Test
    void shouldReturnTheCorrectMorseCode(){
        MorseEncoder encode = new Encoder(MorseCodecMap.getInstance());
        
        String text = "a";
        String expected = ".-";
        String obtained = encode.encode(text);

        assertEquals(expected, obtained);

        text = "A";
        expected = ".-";
        obtained = encode.encode(text);

        assertEquals(expected, obtained);
    }
    @Test
    void shouldReturnQuestionMarkForUnknownLetters(){
        MorseEncoder encode = new Encoder(MorseCodecMap.getInstance());
        
        String text = "ç";
        String expected = "?";
        String obtained = encode.encode(text);

        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnTheCorrectCodedWord(){
        MorseEncoder encode = new Encoder(MorseCodecMap.getInstance());
        
        String text = "abacaxi";
        String expected = ".-,-...,.-,-.-.,.-,-..-,..";
        String obtained = encode.encode(text);

        assertEquals(expected, obtained);

        text = "abaçaxi";
        expected = ".-,-...,.-,?,.-,-..-,..";
        obtained = encode.encode(text);

        assertEquals(expected, obtained);

        text = "1234567890";
        expected = ".----,..---,...--,....-,.....,-....,--...,---..,----.,-----";
        obtained = encode.encode(text);

        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnTheCorrectCodedText(){
        MorseEncoder encode = new Encoder(MorseCodecMap.getInstance());
        
        String text = "abacaxi com limão";
        String expected = ".-,-...,.-,-.-.,.-,-..-,.., ,-.-.,---,--, ,.-..,..,--,?,---";
        String obtained = encode.encode(text);

        assertEquals(expected, obtained);

        
        text = "abacaxi com limão\ngelo e wiskey";
        expected = ".-,-...,.-,-.-.,.-,-..-,.., ,-.-.,---,--, ,.-..,..,--,?,---";
        expected += "\n";
        expected += "--.,.,.-..,---, ,., ,.--,..,...,-.-,.,-.--";
        obtained = encode.encode(text);

        assertEquals(expected, obtained);
    }
}
