package it.polito.recursion;

public class Fibonacci {

	public long recursiveFibonacci(long N) {
		if(N==0)
			return 0 ;
		if(N==1)
			return 1 ;
		
		long left = recursiveFibonacci(N-1) ;
		long right = recursiveFibonacci(N-2) ;
		
		return left + right ;
	}
	
	public long iterativeFibonacci(long N) {
		if(N==0)
			return 0 ;
		if(N==1)
			return 1 ;
		
		// now we know that N >= 2
		
		long i = 2 ;
		
		long fib1 = 1 ; // fib(N-1)
		long fib2 = 0 ; // fib(N-1)
		
		while( i<=N ) {
			long fib = fib1 + fib2 ;
			fib2 = fib1 ;
			fib1 = fib ;
			i++ ;
		}
		
		return fib1 ;
		
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Fibonacci fibo = new Fibonacci() ;
		
		for( long n=0 ; n<100; n++) {
			long f = fibo.iterativeFibonacci(n) ;

			System.out.format("Fib(%d)  = %d\n", n, f) ;
			
		}

	}

}
