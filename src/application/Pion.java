package application;

public class Pion extends Piece{
	Plateau p;
	Boolean b;//booleen premier coup pion
	
	public Pion(coul c,type allie, Plateau p) {
		super(c, allie,"pion");
		this.b=true;
		this.p=p;
	}

	public boolean estpossible(int x, int y, int destx , int desty) {
		if(this.allie==type.a) {
			System.out.println("allie");
			if((this.b && y-desty<=2 && y-desty>0 && x==destx)||(y-desty==1 && x==destx)) {
				this.b=false;
				return true;
				
			}
			else {
				return false;
			}
		}
		else {return false;}
	}

}
