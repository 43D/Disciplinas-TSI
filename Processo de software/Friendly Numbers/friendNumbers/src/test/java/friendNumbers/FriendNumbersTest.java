package friendNumbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class FriendNumbersTest {

	@Test
	void shouldReturnTrueBecauseTheNumbersAreInvertedFriends() {
		FriendNumbers friendNumbers = new FriendNumbers();
		
		long numberA = 13;
		long numberB = 31;
		
		boolean areFriends = friendNumbers.areInvertedFriends(numberA, numberB);
		
		assertTrue(areFriends);
	}
	
	@Test
	void shouldReturnFalseBecauseTheNumbersAreNotInvertedFriends() {
		FriendNumbers friendNumbers = new FriendNumbers();
		
		long numberA = 15;
		long numberB = 31;
		
		boolean areFriends = friendNumbers.areInvertedFriends(numberA, numberB);
		
		assertFalse(areFriends);
	}

	@Test
    void shouldReturnTrueBecauseTheNumbersAreAmicableFriends() {
        FriendNumbers friendNumbers = new FriendNumbers();

		long numberA = 220;
		long numberB = 284;

        boolean areAmicable = friendNumbers.areAmicableNumbers(numberA, numberB);

        assertTrue(areAmicable);
    }

    @Test
    void shouldReturnFalseBecauseTheNumbersAreNotAmicableFriends() {
        FriendNumbers friendNumbers = new FriendNumbers();

		long numberA = 250;
		long numberB = 800;

        boolean areAmicable = friendNumbers.areAmicableNumbers(numberA, numberB);

        assertFalse(areAmicable);
    }

	@Test
    void shouldReturnTrueBecauseTheNumbersAreFriendly() {
        FriendNumbers friendNumbers = new FriendNumbers();

		long numberA = 30;
		long numberB = 140;

        boolean areFriendly = friendNumbers.areFriendlyNumbers(numberA, numberB);

        assertTrue(areFriendly);
    }

    @Test
    void shouldReturnFalseBecauseTheNumbersAreNotFriendly() {
        FriendNumbers friendNumbers = new FriendNumbers();

		long numberA = 145;
		long numberB = 457;

        boolean areFriendly = friendNumbers.areFriendlyNumbers(numberA, numberB);

        assertFalse(areFriendly);
    }

}
