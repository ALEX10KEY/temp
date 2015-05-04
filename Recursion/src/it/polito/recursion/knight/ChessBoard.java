package it.polito.recursion.knight;

public class ChessBoard {

	private int size ;
	private int numCells ;
	private int[][] touched ;
	
	public ChessBoard(int size) {
		this.size = size ;
		touched = new int[size][size] ;
		
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				touched[i][j] = 0 ;
		

	}
	
	public boolean isValid(Cell c) {
		return c.getI()>=0 && c.getI()<size &&
				c.getJ()>=0 && c.getJ()<size ;
	}
	
	public boolean isFree(Cell c) {
		assert isValid(c) ;
		return touched[c.getI()][c.getJ()]==0 ;
	}
	
	public void occupy(Cell c, int lev) {
		assert isValid(c) && touched[c.getI()][c.getJ()] == 0 ;
		touched[c.getI()][c.getJ()] = lev ;
	}
	
	public void free(Cell c) {
		assert isValid(c) && touched[c.getI()][c.getJ()] != 0 ;
		touched[c.getI()][c.getJ()] = 0 ;
	}

	public void show() {
		System.out.println("-----------------------") ;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.format("%2d  ", touched[i][j]) ;
			}
			System.out.println();
		}
			
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
