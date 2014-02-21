package prime;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * @author mikelambert
 *
 */
public class Eratosthenes {

	
	
	public static void main(String[] args) {
		
		Eratosthenes e = new Eratosthenes();
		
		e.getPrimes(97);
		
		e.isPrime(97);
		e.isPrime(99);
		
		System.out.println(e.getE());
	}
	
	public double getE() {
		
		double n = 100000000000.0;
		double i = 1.0 + 1.0/n;
		return Math.pow(i, n); // (1 + 1/n)^n
		
	}
	
	public BigInteger factorial(int n) {
		BigInteger f = new BigInteger("1");
		for(int i = 1; i <= n; i++) {
			f = f.multiply(new BigInteger(Integer.toString(i)));
		}
		System.out.println("factorial of "+n+" is " + f);
		return f;
	}
	
	public List<Integer> getPrimes(int upTo)
	{
		int[] primes = new int[upTo + 1];
		
		for (int i = 0; i <= upTo; i++) {
			primes[i] = 1;
		}
		
		primes[0] = 0;
		primes[1] = 0;
		
		for (int i = 2; i <= Math.sqrt(upTo); i++) {
			
			if (primes[i] == 1) {
				for (int j = 2; j*i <= upTo; j++){
					primes[j*i] = 0;
				}
			}
		}
		
		List<Integer> returnList = new LinkedList<Integer>();
		
		for(int i = 0; i < primes.length; i++) {
			if (primes[i] == 1) {
				returnList.add(i);
			}		
		}
		
		System.out.println(returnList);
		return returnList;
		
	}
	
	/**
	 * The gist is that factors come in pairs, called factor pairs.  The lower of which will 
	 * always be less than the square root.
	 * 
	 * e.g.  36
	 * factors:   1 2 3    [6]            12            18                         36
	 * 
	 * pairs: [1, 36] [2, 18] [3, 12] [6, 6] [12, 3] [18, 2] [1, 36] 
	 * 
	 * @param number
	 * @return
	 */
	public boolean isPrime(int number) 
	{
		for (int i = 2; i < Math.sqrt(number); i++) {
			
			if (number % i == 0 ) {
				System.out.println("not prime: " + number);
				return false;
			}	
		}

		System.out.println("is prime: " + number);
		return true;
		
	}
}
