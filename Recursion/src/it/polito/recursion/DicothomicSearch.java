package it.polito.recursion;

/**
 * Some examples of simple recursive algorithms: 
 * Binomial Search in an ordered vector of integer numbers.
 * 
 * @author Fulvio Corno <fulvio.corno@polito.it>
 * @version 1.0
 *
 */
public class DicothomicSearch {

	/**
	 * Find whether the vector v contains element x. The vector v must be sorted
	 * in ascending order.
	 * 
	 * @param v
	 *            The vector to search
	 * @param x
	 *            The value to be found
	 * @return If x is found, return the index of a cell containing x. If x is
	 *         not found, return (-1)
	 */
	public int find(int[] v, int x) {
		return find(v, 0, v.length - 1, x);
	}

	/**
	 * Find whether the vector v contains element x. The serch is limited to the
	 * subset of the vector whose indices go from a to b. This function is
	 * recursive.
	 * 
	 * @param v
	 *            The vector to be searched
	 * @param a
	 *            The leftmost index of the vector portion to search
	 * @param b
	 *            The rightmost index of the vector portion to search
	 * @param x
	 *            The value to be searched
	 * @return If x is found, return the index of a cell containing x. If x is
	 *         not found, return (-1).
	 */
	private int find(int[] v, int a, int b, int x) {

		if (a == b) {
			// trivial case: 1-lenght vector
			if (v[a] == x)
				return a;
			else
				return -1;
		} else {
			int c = (a + b) / 2; // middle point

			if (v[c] >= x) {
				// v[c] is too large -> search left
				return find(v, a, c, x);
			} else {
				// v[c] is too small -> search right
				return find(v, c+1, b, x);
			}

		}
	}

	
	public int findIterative(int[] v, int x) {
		int a = 0 ;
		int b = v.length-1 ;
		
		while( a != b ) {
			int c = (a + b) / 2; // middle point
			
			if (v[c] >= x) {
				// v[c] is too large -> search left
				b = c ;
			} else {
				// v[c] is too small -> search right
				a = c+1 ;
			}
			
		}
		
		if (v[a] == x)
			return a;
		else
			return -1;
	}

	
	private void test() {
		int[] v = { 1, 3, 4, 6, 8, 9, 11, 12, 13 };

		for (int i = 0; i < 15; i++) {
			int loc = find(v, i);
			if(loc==-1)
				System.out.format("Value %d not found\n", i) ;
			else
				System.out.format("Value %d found at index %d\n", i, loc) ;

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DicothomicSearch bs = new DicothomicSearch() ;
		bs.test() ;
	}

}
