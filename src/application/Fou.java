package application;

public class Fou  extends Piece{
	Plateau p;
	public Fou(coul c, type all, String n,Plateau p) {
		super(c, all, n);
		this.p=p;
	}
	public boolean estpossible(int x, int y, int destx, int desty) {
		if(x!=destx && y!=desty && (pente(x,y,destx,desty)==1 || pente(x,y,destx,desty)==-1) && this.diag(x,y,destx,desty)) {
			return true;
		}
		else {return false;}
	}
	
	static float pente(int x, int y, int destx, int desty) {
		if(x>destx) {
			return (((y-desty)/(x-destx)));
		}
		else {
			return (((desty-y)/(destx-x)));
		}
	}
	
	public boolean diag(int x, int y, int destx, int desty) {
		boolean ret=true;
		if(pente(x,y,destx,desty)==1) {//--\--
			if(x>destx) {//haut gauche
				for(int i=1;i<x-destx+1;i++) {
					
					if(i==x-destx) {
						if(this.p.pieces.get(y-i).get(x-i)!=null && this.p.pieces.get(y-i).get(x-i).allie==this.p.pieces.get(y).get(x).allie) {
						
						ret=false;
						}
					}
					else {
						if(this.p.pieces.get(y-i).get(x-i)!=null) {
							
							ret=false;
						}
					}
					
				}
				
			}
			else {//bas droite
				for(int i=1;i<destx-x+1;i++) {
					if(i==destx-x) {
						if(this.p.pieces.get(y+i).get(x+i)!=null && this.p.pieces.get(y+i).get(x+i).allie==this.p.pieces.get(y).get(x).allie) {
						
						ret=false;
						}
					}
					else {
						if(this.p.pieces.get(y+i).get(x+i)!=null) {
							
							ret=false;
						}
					}
				}
			}
			
		}
		else {//--/--
			if(x>destx) {//bas a gauche
				for(int i=1;i<x-destx+1;i++) {
					if(i==x-destx) {
						if(this.p.pieces.get(y+i).get(x-i)!=null && this.p.pieces.get(y+i).get(x-i).allie==this.p.pieces.get(y).get(x).allie) {
						
						ret=false;
						}
					}
					else {
						if(this.p.pieces.get(y+i).get(x-i)!=null) {
							
							ret=false;
						}
					}
				}
			}
			else {//haut droite
				for(int i=1;i<destx-x+1;i++) {
					if(i==destx-x) {
						if(this.p.pieces.get(y-i).get(x+i)!=null && this.p.pieces.get(y-i).get(x+i).allie==this.p.pieces.get(y).get(x).allie) {
						
						ret=false;
						}
					}
					else {
						if(this.p.pieces.get(y-i).get(x+i)!=null) {
							
							ret=false;
						}
					}
				}
			}
		}
		return ret;
	}
	
	

}
