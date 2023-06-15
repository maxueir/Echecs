package application;

public class Pion extends Piece{
	Plateau p;
	Boolean b;//booleen premier coup pion
	int enpassant;//numero du tour ou le pion a avancé de deux cases 
	
	public Pion(coul c,type allie, Plateau p) {
		super(c, allie,"pion");
		this.b=true;
		this.enpassant=-1;
		this.p=p;
	}

	public boolean estpossible(int x, int y, int destx , int desty) {
		if(this.allie==type.a) {
			if((this.b && y-desty==2 && x==destx && this.p.pieces.get(y-1).get(x)==null && this.p.pieces.get(y-2).get(x)==null)) {
				this.b=false;
				this.enpassant=this.p.numerodutour;
				return true;
			}
			else if((y-desty==1 && x==destx  && this.p.pieces.get(y-1).get(x)==null)||(y-desty==1 && x==destx+1 && this.p.pieces.get(y-1).get(x-1)!=null && this.p.pieces.get(y-1).get(x-1).allie==type.e )||(y-desty==1 && x==destx-1 && this.p.pieces.get(y-1).get(x+1)!=null && this.p.pieces.get(y-1).get(x+1).allie==type.e)) {
				this.b=false;
				return true; //TODO test de manger pion blanc vers pion blanc puis implementer mangage pion noir
				
			}
			//prise en passant blanc vers gauche
			else if((y-desty==1 && x==destx+1 && this.p.pieces.get(y-1).get(x-1)==null && this.p.pieces.get(y).get(x-1)!=null && this.p.pieces.get(y).get(x-1).nom.equals("pion") && this.p.pieces.get(y).get(x-1).allie==type.e && ((Pion)this.p.pieces.get(y).get(x-1)).enpassant==this.p.numerodutour-1 )){
				this.p.pieces.get(y).set(x-1, null);
				return true;
			}
			//prise en passant blanc vers droite
			else if((y-desty==1 && x==destx-1 && this.p.pieces.get(y-1).get(x+1)==null && this.p.pieces.get(y).get(x+1)!=null && this.p.pieces.get(y).get(x+1).nom.equals("pion") && this.p.pieces.get(y).get(x+1).allie==type.e && ((Pion)this.p.pieces.get(y).get(x+1)).enpassant==this.p.numerodutour-1 )){
				this.p.pieces.get(y).set(x+1, null);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if((this.b && desty-y==2 && x==destx && this.p.pieces.get(y+1).get(x)==null && this.p.pieces.get(y+2).get(x)==null)) {
				this.b=false;
				this.enpassant=this.p.numerodutour;
				return true;
			}
			else if((desty-y==1 && x==destx && this.p.pieces.get(y+1).get(x)==null)||(desty-y==1 && x==destx+1 && this.p.pieces.get(y+1).get(x-1)!=null && this.p.pieces.get(y+1).get(x-1).allie==type.a )||(desty-y==1 && x==destx-1 && this.p.pieces.get(y+1).get(x+1)!=null && this.p.pieces.get(y+1).get(x+1).allie==type.a)) {
				this.b=false;
				return true;
				
			}
			//prise en passant noir vers gauche
			else if((desty-y==1 && x==destx+1 && this.p.pieces.get(y+1).get(x-1)==null && this.p.pieces.get(y).get(x-1)!=null && this.p.pieces.get(y).get(x-1).nom.equals("pion") && this.p.pieces.get(y).get(x-1).allie==type.a && ((Pion)this.p.pieces.get(y).get(x-1)).enpassant==this.p.numerodutour )){
				this.p.pieces.get(y).set(x-1, null);
				return true;
			}
			//prise en passant blanc vers droite
			else if((desty-y==1 && x==destx-1 && this.p.pieces.get(y+1).get(x+1)==null && this.p.pieces.get(y).get(x+1)!=null && this.p.pieces.get(y).get(x+1).nom.equals("pion") && this.p.pieces.get(y).get(x+1).allie==type.a && ((Pion)this.p.pieces.get(y).get(x+1)).enpassant==this.p.numerodutour )){
				this.p.pieces.get(y).set(x+1, null);
				return true;
			}
			else {
				
				
				return false;
			}
		}
	}

}
