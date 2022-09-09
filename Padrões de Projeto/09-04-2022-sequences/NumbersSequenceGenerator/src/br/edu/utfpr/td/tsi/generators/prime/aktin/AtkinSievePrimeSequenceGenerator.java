package br.edu.utfpr.td.tsi.generators.prime.aktin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.utfpr.td.tsi.generators.AbstractSequenceGenerator;

public class AtkinSievePrimeSequenceGenerator extends AbstractSequenceGenerator{
	private int limit;
	private List<Integer> primes;
	private boolean[] sieve;
	
	private void init(int limit)
	{
		if(isLessThanTwo(limit))
			limit = 0;
		
		this.limit = limit;
		this.primes = new ArrayList<>(limit/10);
		this.sieve = new boolean[limit];
		Arrays.fill(this.sieve, false);
	}
	
	@Override
	public List<Integer> generateSequence(final int MAX)
	{
		init(MAX);
		
		if(isLessThanTwo(MAX))
			return primes;
		
		programLifeCycle(MAX);
		
		return primes;
	}
	
	private void programLifeCycle(final int MAX) {
		final int TESTING_LIMIT = squareRootOf(MAX); 

		calculePositionSieve(TESTING_LIMIT);		
		checkSievePosition(TESTING_LIMIT);
		addInitialPrimes();
		makeListOfPrime();
	}
	
	private void calculePositionSieve(final int TESTING_LIMIT) {
		for (int index=0; index<TESTING_LIMIT; index++)	{
			calculePositionSieve(index, TESTING_LIMIT);
		}
	} 
	
	private void calculePositionSieve(final int TESTING_LIMIT, int i) {
		for (int j=0; j<TESTING_LIMIT; j++)	{
			calculeFirstPositionSieve(i, j);
			calculeSecondPositionSieve(i, j);
			calculeThirdPositionSieve(i, j);			
		}
	} 
	
	private void calculeFirstPositionSieve(final int j, final int i) {
		final int n = 4*i*i + j*j;
		if (n <= limit && (n % 12 == 1 || n % 12 == 5))				
			flipSievePosition(n);
	}
	
	private void calculeSecondPositionSieve(final int j, final int i) {
		final int n = 3*i*i + j*j;
		if (n <= limit && n % 12 == 7)				
			flipSievePosition(n);
	}
	
	private void calculeThirdPositionSieve(final int j, final int i) {
		final int n = 3*i*i - j*j;
		if (n <= limit && i > j && n % 12 == 11)					
			flipSievePosition(n);
	}
	
	private void checkSievePosition(final int TESTING_LIMIT) {
		for (int index=0; index<TESTING_LIMIT; index++)	{
			if (isPrime(index))
				checkSievePosition(index, TESTING_LIMIT);
		}
	}
	
	private void checkSievePosition(final int TESTING_LIMIT, int i) {
		int k = i*i;
		for (int j=k; j<limit; j+=k){
			markSievePositionAsFalse(j);
		}
	} 
	
	public void makeListOfPrime() {
		for(int value=5; value < sieve.length; value++) {
			if(isPrime(value))
				primes.add(value);
		}
	}
	
	private static boolean isLessThanTwo(final int NUMBER) {
		if (NUMBER < 2)
			return true;
		return false;
	}
	
	private static int squareRootOf(final int NUMBER) {
		return (int) (Math.ceil(Math.sqrt(NUMBER)));
	}
	
	public void addInitialPrimes() {
		primes.add(2);
		primes.add(3);
	}
	
	private void flipSievePosition(int position) {
		if(sieve[position])
			System.out.println(position);
		sieve[position] = !sieve[position];
	}

	private void markSievePositionAsFalse(int sievePosition) {
		sieve[sievePosition] = false;
	}
	
	private boolean isPrime(int value) {
		int sievePosition = value;
		return sieve[sievePosition];
	}
}