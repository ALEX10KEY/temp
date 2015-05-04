package it.polito.recursion.knight;

import java.util.LinkedList;
import java.util.List;

public class KnightMove {

	static private final int[][] offsets = { { 1, 2 }, { 1, -2 }, { -1, 2 },
			{ -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };
	/* stores all legal moves for the Knight */

	public List<Cell> findLegalMoves(Cell c, ChessBoard b) {
		List<Cell> moves = new LinkedList<Cell>();

		for(int n=0; n<offsets.length; n++) {
			Cell dest = new Cell(  c.getI() + offsets[n][0], c.getJ()+offsets[n][1] ) ;
			if(b.isValid(dest) && b.isFree(dest))
				moves.add(dest) ;
		}
		
		return moves;
	}
	
	public boolean tryMove(Cell c, ChessBoard b, int level) {
		
		if (level>b.getSize()*b.getSize()) {
			b.show() ;
			return true ; // path found!!!
		}
		
		boolean result = false ;
		
		List<Cell> moves = findLegalMoves(c, b) ;
		for(Cell d: moves) {
			b.occupy(d, level) ;
			//b.show() ;
			result = /*result ||*/ tryMove(d, b, level+1) ;
			b.free(d) ;
		}
		return result ;
	}
	
	
	public void runSearch() {
		ChessBoard cb = new ChessBoard(5) ;
		Cell init = new Cell(0,0) ;
		
		cb.occupy(init, 1) ;
		tryMove(init, cb, 2) ;
	}
	
	static public void main(String args[]) {
		KnightMove km = new KnightMove() ;
		
		km.runSearch() ;
	}

}
