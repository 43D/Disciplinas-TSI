package friendNumbers.verificators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvertedFriendsTest {

	@Test
	void shouldReturnSameValue() {
		InvertedFriends invertedFriends = new InvertedFriends();
		
		long value = 3;
		long expected = 3;
		
		long obtained = invertedFriends.inverseOf(value);
		
		assertEquals(expected, obtained);
	}

	
	@Test
	void shouldReturnTheInverseOfValue() {
		InvertedFriends invertedFriends = new InvertedFriends();
		
		long value = 21;
		long expected = 12;
		
		long obtained = invertedFriends.inverseOf(value);
		
		assertEquals(expected, obtained);
	}
	
	@Test
	void shouldReturnTrueBecauseTheNumbersAreInvertedFriends() {
		InvertedFriends invertedFriends = new InvertedFriends();
		
		boolean areFriends = invertedFriends.areFriends(13, 31);
		
		assertTrue(areFriends);
	}
	
	@Test
	void shouldReturnFalseBecauseTheNumbersAreNotInvertedFriends() {
		InvertedFriends invertedFriends = new InvertedFriends();
		
		boolean areFriends = invertedFriends.areFriends(15, 754);
		
		assertFalse(areFriends);
	}
}
