package it.polito.recursion;

public class Factorial {
	
	/**
	 * Compute the factorial (N!) of a positive integer using a recursive algorithm 
	 * @param N argument of the factorial function 
	 * @return result of the factorial computation
	 */
	public long recursiveFactorial(long N) {
		long result = 1 ;
		
		if ( N == 0 )
			return 1 ;
		else {
			result = recursiveFactorial(N-1) ;
			result = N * result ;
			return result ;
		}
	}
	
	/**
	 * Compute the factorial (N!) of a positive integer using an iterative algorithm 
	 * @param N argument of the factorial function 
	 * @return result of the factorial computation
	 */

	public long iterativeFactorial(long N) {
		long result = 1 ;
		
		for (long i=2; i<=N; i++)
			result = result * i ;
		
		return result ;
	}
	
	public static void main(String args[]) {
		Factorial fact = new Factorial() ;
		
		// long ris = fact.recursiveFactorial(5) ;
		
		for( long n = 1 ; n<20 ; n++) {
			long rF = fact.recursiveFactorial(n) ;
			long iF = fact.iterativeFactorial(n) ; 
			System.out.format("%d !  = %d - %d\n", n, rF, iF) ;
		}
	}
	

}
