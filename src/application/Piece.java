package application;

public class Piece {
	public String nom;
	enum coul {b,n};//blanc ou noir
	coul couleur;
	
	enum type{a,e};//alie ou ennemis
	type allie;
	
	public Piece(coul c, type all,String n) {
		this.couleur=c;
		this.allie=all;
		this.nom=n;
	}
	
}
