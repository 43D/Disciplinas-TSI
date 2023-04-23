package friendNumbers.verificators;

import friendNumbers.FriendNumbersVerificator;

public class InvertedFriends implements FriendNumbersVerificator {

	public long inverseOf(long number) {
		long inverted = 0;

		while (number > 0) {
			long rest = number % 10;
			inverted = (inverted * 10) + rest;
			number = (number - rest) / 10;
		}

		return inverted;
	}

	@Override
	public boolean areFriends(final long numberA, final long numberB) {
		long aPower2 = numberA * numberA;
		long bPower2 = numberB * numberB;

		long bPower2Inverted = inverseOf(bPower2);

		return aPower2 == bPower2Inverted;
	}
}
