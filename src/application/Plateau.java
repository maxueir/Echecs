package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.Piece.coul;
import application.Piece.type;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Plateau extends GridPane{
	ArrayList<ArrayList<Piece>> pieces ;
	boolean blanc;//true si tour = blanc
	boolean selec;//true si une piece du joueur est selectionnee
	int selx;
	int sely;
	int numerodutour;
	Piece selpiece;//piece selectionnee
	
	public Plateau() throws FileNotFoundException {
		this.blanc=true;
		this.selec=false;
		this.numerodutour=0;
		this.setOnMouseClicked(e ->
		{
			
			int x=(int)Math.floor((e.getX())/(this.getWidth()/8));
			int y=(int)Math.floor((e.getY())/(this.getHeight()/8));
			
			
			Piece p=this.pieces.get(y).get(x);
			
			if(this.blanc) {
				
				if(p!=null && p.couleur==coul.b) {
					this.selec=true;
					this.selx=x;
					this.sely=y;
					this.selpiece=p;
				}
				else if(selec) {
					if(this.selpiece.nom.equals("pion")) {
						if(((Pion)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=false;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("tour")) {
						if(((Tour)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=false;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("roi")) {
						if(((Roi)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=false;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("cavalier")) {
						if(((Cavalier)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=false;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("fou")) {
						if(((Fou)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=false;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("dame")) {
						if(((Dame)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=false;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					
					
					
					
				}
			}
			else {
				if(p!=null && p.couleur==coul.n) {
					this.selec=true;
					this.selx=x;
					this.sely=y;
					this.selpiece=p;
				}
				else if(selec) {
					if(this.selpiece.nom.equals("pion")) {
						if(((Pion)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=true;
							this.numerodutour++;
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("tour")) {
						if(((Tour)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=true;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("roi")) {
						if(((Roi)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=true;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("cavalier")) {
						if(((Cavalier)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=true;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("fou")) {
						if(((Fou)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=true;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					else if(this.selpiece.nom.equals("dame")) {
						if(((Dame)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=true;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}

						else {selec=false;}
					}
					
					
					
					
				}
			}
		});
		
		
		pieces = new ArrayList<ArrayList<Piece>>();
		for(int i=0;i<8;i++) {
			ArrayList<Piece> test = new ArrayList<Piece>();
			if(i==6) {
				for(int j=0;j<8;j++) {
					test.add(new Pion(coul.b,type.a,this));
				}
			}
			else if(i==1){
				for(int j=0;j<8;j++) {
					test.add(new Pion(coul.n,type.e,this));
				}
			}
			else if(i==0) {
				for(int j=0;j<8;j++) {
					if(j==0 || j==7) {
						test.add(new Tour(coul.n, type.e, "tour", this));
					}
					else if(j==4) {
						test.add(new Roi(coul.n, type.e, "roi", this));
					}
					else if(j==1 || j==6) {
						test.add(new Cavalier(coul.n, type.e, "cavalier", this));
					}
					else if(j==2 || j==5) {
						test.add(new Fou(coul.n, type.e, "fou", this));
					}
					else if(j==3) {
						test.add(new Dame(coul.n, type.e, "dame", this));
					}
				}
			}
			else if(i==7) {
				for(int j=0;j<8;j++) {
					if(j==0 || j==7) {
						test.add(new Tour(coul.b, type.a, "tour", this));
					}
					else if(j==3) {
						test.add(new Roi(coul.b, type.a, "roi", this));
					}
					else if(j==1 || j==6) {
						test.add(new Cavalier(coul.b, type.a, "cavalier", this));
					}
					else if(j==2 || j==5) {
						test.add(new Fou(coul.b, type.a, "fou", this));
					}
					else if(j==4) {
						test.add(new Dame(coul.b, type.a, "dame", this));
					}
				}
			}
			else {
				
				for(int j=0;j<8;j++) {
					test.add(null);
				}
			}
			pieces.add(test);
			
		}
		this.affichage();
		
		
		
		final int numCols = 8 ;
        final int numRows = 8 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            this.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            this.getRowConstraints().add(rowConst);         
        }
        this.setId("damier");
	}
	
	public void affichage() throws FileNotFoundException {//TODO optimisation charger une seule fois chaque image ou ne supprimer et recharger que celle concernee
		this.getChildren().clear();
		Image im=(new Image(new FileInputStream("images/pion_blanc.png")));
		Image im1=(new Image(new FileInputStream("images/pion_noir.png")));
		Image im2=new Image(new FileInputStream("images/tour_blanche.png"));
		Image im3=new Image(new FileInputStream("images/tour_noire.png"));
		Image im4=new Image(new FileInputStream("images/roi_blanc.png"));
		Image im5=new Image(new FileInputStream("images/roi_noir.png"));
		Image im6=new Image(new FileInputStream("images/cavalier_blanc.png"));
		Image im7=new Image(new FileInputStream("images/cavalier_noir.png"));
		Image im8=new Image(new FileInputStream("images/fou_blanc.png"));
		Image im9=new Image(new FileInputStream("images/fou_noir.png"));
		Image im10=new Image(new FileInputStream("images/dame_blanche.png"));
		Image im11=new Image(new FileInputStream("images/dame_noire.png"));
		for(int i=0;i<pieces.size();i++) {
			for (int j=0;j<pieces.get(i).size();j++) {
				
				
						
				if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("pion") && pieces.get(i).get(j).couleur==coul.b) {
					
					ImageView iv=new ImageView(im);
					
					iv.setFitHeight(this.getHeight()/8);
					iv.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv, j, i);
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("pion") && pieces.get(i).get(j).couleur==coul.n) {
					
					ImageView iv1=new ImageView(im1);
					
					iv1.setFitHeight(this.getHeight()/8);
					iv1.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv1.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv1.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv1, j, i);
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("tour") && pieces.get(i).get(j).couleur==coul.b) {
					ImageView iv2=new ImageView(im2);
					
					iv2.setFitHeight(this.getHeight()/8);
					iv2.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv2.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv2.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv2, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("tour") && pieces.get(i).get(j).couleur==coul.n) {
					ImageView iv3=new ImageView(im3);
					
					iv3.setFitHeight(this.getHeight()/8);
					iv3.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv3.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv3.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv3, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("roi") && pieces.get(i).get(j).couleur==coul.n) {
					ImageView iv5=new ImageView(im5);
					
					iv5.setFitHeight(this.getHeight()/8);
					iv5.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv5.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv5.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv5, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("roi") && pieces.get(i).get(j).couleur==coul.b) {
					ImageView iv4=new ImageView(im4);
					
					iv4.setFitHeight(this.getHeight()/8);
					iv4.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv4.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv4.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv4, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("cavalier") && pieces.get(i).get(j).couleur==coul.b) {
					ImageView iv6=new ImageView(im6);
					
					iv6.setFitHeight(this.getHeight()/8);
					iv6.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv6.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv6.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv6, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("cavalier") && pieces.get(i).get(j).couleur==coul.n) {
					ImageView iv7=new ImageView(im7);
					
					iv7.setFitHeight(this.getHeight()/8);
					iv7.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv7.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv7.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv7, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("fou") && pieces.get(i).get(j).couleur==coul.n) {
					ImageView iv9=new ImageView(im9);
					
					iv9.setFitHeight(this.getHeight()/8);
					iv9.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv9.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv9.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv9, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("fou") && pieces.get(i).get(j).couleur==coul.b) {
					ImageView iv8=new ImageView(im8);
					
					iv8.setFitHeight(this.getHeight()/8);
					iv8.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv8.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv8.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv8, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("dame") && pieces.get(i).get(j).couleur==coul.b) {
					ImageView iv10=new ImageView(im10);
					
					iv10.setFitHeight(this.getHeight()/8);
					iv10.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv10.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv10.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv10, j, i);
					 
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("dame") && pieces.get(i).get(j).couleur==coul.n) {
					ImageView iv11=new ImageView(im11);
					
					iv11.setFitHeight(this.getHeight()/8);
					iv11.setFitWidth(this.getWidth()/8);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv11.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv11.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv11, j, i);
					 
				}
			}
		}
	}

}
