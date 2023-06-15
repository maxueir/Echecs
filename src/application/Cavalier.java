package application;

public class Cavalier extends Piece{
	Plateau p;
	public Cavalier(coul c, type all, String n,Plateau p) {
		super(c, all, n);
		this.p=p;
	}
	
	public boolean estpossible(int x, int y, int destx, int desty) {
		int decx=Math.max(x, destx)-Math.min(destx, x);
		int decy=Math.max(y, desty)-Math.min(desty, y);
		if((decx+decy==3)) {
			System.out.println("hey");
			return true;
		}
		else {
			System.out.println("ay");
			return false;
		}
		
	}

}
