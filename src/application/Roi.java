package application;

public class Roi extends Piece{
	Plateau p;
	public Roi(coul c, type all, String n,Plateau p) {
		super(c, all, n);
		this.p=p;
	}
	
		public boolean estpossible(int x,int y,int destx,int desty) {
			if((y==desty && destx-x==1 && (this.p.pieces.get(desty).get(destx)==null || this.p.pieces.get(desty).get(destx).allie!=this.allie)) ) {
				return true;
			}
			else if((y==desty && x-destx==1 && (this.p.pieces.get(desty).get(destx)==null || this.p.pieces.get(desty).get(destx).allie!=this.allie)) ) {
				return true;
			}
			else if((y==desty+1 && (destx==x || destx==x+1|| destx==x-1) && (this.p.pieces.get(desty).get(destx)==null || this.p.pieces.get(desty).get(destx).allie!=this.allie)) ) {
				return true;
			}
			else if((y==desty-1 && (destx==x || destx==x+1|| destx==x-1) && (this.p.pieces.get(desty).get(destx)==null || this.p.pieces.get(desty).get(destx).allie!=this.allie)) ) {
				return true;
			}
			
			else {
				return false;
			}
		}
	
	

}
