package application;

public class Tour extends Piece{
	Plateau p;
	
	public Tour(coul c, type all, String n, Plateau p) {
		super(c, all, n);
		this.p=p;
	}
	
	public boolean estpossible(int x,int y,int destx,int desty) {
		if((x!=destx && y==desty && this.ligne(x,destx,y)) ) {
			return true;
		}
		else if((x==destx && y!=desty && this.colonne(y, desty,x))) {
			return true;
		}
		
		
		else {
			return false;
		}
	}
	public boolean ligne(int x,int destx,int y) {
		boolean ret=true;
		if(x>destx) {
			for(int i=1;i<x-destx+1;i++) {
				if(i==x-destx) {
					if(this.p.pieces.get(y).get(x-i)!=null && this.p.pieces.get(y).get(x-i).allie==this.p.pieces.get(y).get(x).allie) {
				
					ret=false;
					}
				}
				else {
					if(this.p.pieces.get(y).get(x-i)!=null) {
						ret=false;
					}
				}
			}
		}
		else {
			for(int i=1;i<destx-x+1;i++) {
				if(i==destx-x) {
					if(this.p.pieces.get(y).get(x+i)!=null && this.p.pieces.get(y).get(x+i).allie==this.p.pieces.get(y).get(x).allie) {
				
					ret=false;
					}
				}
				else {
					if(this.p.pieces.get(y).get(x+i)!=null) {
						ret=false;
					}
				}
			}
		}
		return ret;
	}
	public boolean colonne(int y, int desty,int x) {
		boolean ret=true;
		
		if(y>desty) {
			for(int i=1;i<y-desty+1;i++) {
				if(i==y-desty) {
					if(this.p.pieces.get(y-i).get(x)!=null && this.p.pieces.get(y-i).get(x).allie==this.p.pieces.get(y).get(x).allie) {
					System.out.println("a");
					ret=false;
					}
				}
				else {
					if(this.p.pieces.get(y-i).get(x)!=null) {
						System.out.println("b");
						ret=false;
					}
				}
			}
		}
		else {
			for(int i=1;i<desty-y+1;i++) {
				if(i==desty-y) {
					if(this.p.pieces.get(y+i).get(x)!=null && this.p.pieces.get(y+i).get(x).allie==this.p.pieces.get(y).get(x).allie) {
					System.out.println("c");
					ret=false;
				}
				}
				else {
					if(this.p.pieces.get(y+i).get(x)!=null) {
						System.out.println("d");
						ret=false;
					}
				}
			}
		}
		
		
		return ret;
	}

}
