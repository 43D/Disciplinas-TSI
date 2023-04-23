package friendNumbers;

import friendNumbers.verificators.AmicableNumbers;
import friendNumbers.verificators.FriendlyNumbers;
import friendNumbers.verificators.InvertedFriends;

public class FriendNumbers {

	public boolean areInvertedFriends(long a, long b) {
		FriendNumbersVerificator verificator = new InvertedFriends();
		return verificator.areFriends(a, b);
	}

	public boolean areAmicableNumbers(long a, long b) {
		FriendNumbersVerificator verificator = new AmicableNumbers();
		return verificator.areFriends(a, b);
	}

	public boolean areFriendlyNumbers(long a, long b) {
		FriendNumbersVerificator verificator = new FriendlyNumbers();
		return verificator.areFriends(a, b);
	}

}
