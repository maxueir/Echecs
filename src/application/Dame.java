package application;

import application.Piece.coul;
import application.Piece.type;

public class Dame  extends Piece{
	Fou f;
	Tour t;
	Plateau p;
	public Dame(coul c, type all, String n,Plateau p) {
		super(c, all, n);
		this.p=p;
		this.f=new Fou(c, all, n, p);
		this.t=new Tour(c, all, n, p);
	}
	public boolean estpossible(int x, int y, int destx, int desty) {
		return this.f.estpossible(x, y, destx, desty) || this.t.estpossible(x, y, destx, desty);
	}

}
