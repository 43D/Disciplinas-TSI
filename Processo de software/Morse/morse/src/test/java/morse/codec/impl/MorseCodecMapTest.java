package morse.codec.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MorseCodecMapTest {
    @Test
    public void shouldReturnAlwaysTheSameSingletonObject() {
        Object singleton1 = MorseCodecMap.getInstance();
        Object singleton2 = MorseCodecMap.getInstance();
        assertEquals(singleton1, singleton2);
    }

    @Test
    public void shouldReturnTheCorrectMorseCode() {
        MorseCodecMap morseCodecMap = MorseCodecMap.getInstance();

        assertDoesNotThrow(() -> {
            final char letter = 's';
            final String expected = "...";
            final String obtained = morseCodecMap.encode(letter);
            assertTrue(expected == obtained);
        });
    }

    @Test
    public void shouldThrowsAnException() {
        MorseCodecMap morseCodecMap = MorseCodecMap.getInstance();

        final char letter = 'ç';
        assertThrows(Exception.class, () -> morseCodecMap.encode(letter));
    }

    @Test
    public void shouldReturnTheCorrectLetter() {
        MorseCodecMap morseCodecMap = MorseCodecMap.getInstance();

        assertDoesNotThrow(() -> {
            final String morseCode = "---";
            final String expected = "o";
            final String obtained = morseCodecMap.decode(morseCode);
            assertTrue(expected == obtained);
        });
    }

    @Test
    public void ShouldThrowsAnException() {
        MorseCodecMap morseCodecMap = MorseCodecMap.getInstance();

        final String morseCode = "---------";
        assertThrows(Exception.class, () -> morseCodecMap.decode(morseCode));
    }
}
