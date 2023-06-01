package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.Piece.coul;
import application.Piece.type;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Plateau extends GridPane{
	ArrayList<ArrayList<Piece>> pieces ;
	boolean blanc;//true si tour = blanc
	boolean selec;//true si une piece du joueur est selectionnee
	int selx;
	int sely;
	Piece selpiece;//piece selectionnee
	
	public Plateau() throws FileNotFoundException {
		this.blanc=true;
		this.selec=false;
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
						//System.out.println("de "+selx+" "+sely+" a "+x+" "+y);
						//System.out.println(((Pion)this.selpiece).estpossible(selx, sely, x, y));
						if(((Pion)this.selpiece).estpossible(selx, sely, x, y)) {
							this.selec=false;
							this.blanc=false;
							
							this.pieces.get(sely).set(selx,null);
							this.pieces.get(y).set(x, this.selpiece);
							try {
								this.affichage();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					
					
					
					
				}
				else {selec=false;}
			}
			else {
				
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
	
	public void affichage() throws FileNotFoundException {
		for(int i=0;i<pieces.size();i++) {
			for (int j=0;j<pieces.get(i).size();j++) {
				if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("pion") && pieces.get(i).get(j).couleur==coul.b) {
					
					ImageView iv= new ImageView(new Image(new FileInputStream("images/pion_blanc.png")));
					
					iv.setFitHeight(50);
					iv.setFitWidth(50);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv, j, i);
				}
				else if(pieces.get(i).get(j)!=null && pieces.get(i).get(j).nom.equals("pion") && pieces.get(i).get(j).couleur==coul.n) {
					
					ImageView iv= new ImageView(new Image(new FileInputStream("images/pion_noir.png")));
					
					iv.setFitHeight(50);
					iv.setFitWidth(50);
					this.heightProperty().addListener((obs, oldVal, newVal) -> {
						iv.setFitHeight(this.getHeight()/8);
					});
					
					this.widthProperty().addListener((obs, oldVal, newVal) -> {
						iv.setFitWidth(this.getWidth()/8);
					});
					
					this.add(iv, j, i);
				}
				else if(pieces.get(i).get(j)==null) {
					//effacer le contenu de la cellulle
					//clear ou remove ou set null par ex
					 
				}
			}
		}
	}

}
