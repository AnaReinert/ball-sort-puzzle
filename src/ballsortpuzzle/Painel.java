/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballsortpuzzle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Ana e Gabriel
 */
public class Painel extends JPanel{
    
    static String [] bolinhas;
    String nodo;
    int tamanhoJogo;
    
    public Painel(){
    this.setFocusable(true);
    this.setBackground(Color.WHITE);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int x = 50;
        int xAux = 50;
        int yAux = 45;
        if(nodo != null){
                for(int i = 0; i < tamanhoJogo; i ++){
                    for(int j = 0; j < 4; j++){
                       g.drawRect( xAux, yAux, 50, 60);
                       yAux +=60;
                    }
                    yAux = 45;
                    xAux +=60;
                }
                int y = 230;
		String []  ballSortPuzzle = nodo.split("\n");
		ArrayList<String> tubos = new ArrayList<>();
		for(int i = 0; i <= ballSortPuzzle.length -1; i++){
			bolinhas = ballSortPuzzle[i].split(",");
			for(int j = 0; j <= bolinhas.length-1; j++) {
				tubos.add(bolinhas[j]);
			}
		}
		
		ArrayList<String> removeColchete = new ArrayList<>();
		for(int i = 0; i < tubos.size(); i++) {
			removeColchete.add(tubos.get(i).replace("[", ""));
		}
                
		ArrayList<String> versaoFinal = new ArrayList<>();
                for(int i = 0; i < tubos.size(); i++) {
			versaoFinal.add(removeColchete.get(i).replace(" ", ""));
		}
		
		int count;
                
                ///A partir daqui que começa a gerar as bolinhas
		for(int i = 0; i < versaoFinal.size(); i++) { //for que passa por cada string de cor.
			count = 0;
			if(versaoFinal.get(i).contains("]")) { // Anda até o simbolo ].
				String valor = versaoFinal.get(i).replace("]", "");
                                count = 1;
                                if((valor.equals("")) || (valor.equals(""))){
                                    x += 60;
                                    y = 230;
                                }else{
                                 java.awt.Color color = Color.decode(valor);
                                 g.setColor(color);
                                 g.fillOval(x, y, 50, 50);
                                 x += 60;
                                 y = 230;   
                                }
			}
			if(count == 0) {
                            java.awt.Color color = Color.decode(versaoFinal.get(i));
                            g.setColor(color);
                            g.fillOval(x, y, 50, 50);
                            y -= 60;
                        }
		}
        }
    }
    
    public void desenhaBolinha(){
                int x = 50;
                int y = 230;
		String []  ballSortPuzzle = nodo.split("\n");
		ArrayList<String> tubos = new ArrayList<>();
		for(int i = 0; i <= ballSortPuzzle.length -1; i++){
			bolinhas = ballSortPuzzle[i].split(",");
			for(int j = 0; j <= bolinhas.length-1; j++) {
				tubos.add(bolinhas[j]);
			}
		}
		
		ArrayList<String> removeColchete = new ArrayList<>();
		for(int i = 0; i < tubos.size(); i++) {
			removeColchete.add(tubos.get(i).replace("[", ""));
		}
                
		ArrayList<String> versaoFinal = new ArrayList<>();
                for(int i = 0; i < tubos.size(); i++) {
			versaoFinal.add(removeColchete.get(i).replace(" ", ""));
		}
		
		int count;
                
                ///A partir daqui que começa a gerar as bolinhas
                Graphics g = this.getGraphics();
		for(int i = 0; i < versaoFinal.size(); i++) { //for que passa por cada string de cor.
			count = 0;
			if(versaoFinal.get(i).contains("]")) { // Anda até o simbolo ].
				String valor = versaoFinal.get(i).replace("]", "");
                                count = 1;
                                if((valor.equals("")) || (valor.equals(""))){
                                    x += 60;
                                    y = 230;
                                }else{
                                 java.awt.Color color = Color.decode(valor);
                                 g.setColor(color);
                                 g.fillOval(x, y, 50, 50);
                                 x += 60;
                                 y = 230;   
                                }
			}
			if(count == 0) {
                            java.awt.Color color = Color.decode(versaoFinal.get(i));
                            g.setColor(color);
                            g.fillOval(x, y, 50, 50);
                            y -= 60;
                        }
		}
                
    }   

    public String getNodo() {
        return nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public int getTamanhoJogo() {
        return tamanhoJogo;
    }

    public void setTamanhoJogo(int tamanhoJogo) {
        this.tamanhoJogo = tamanhoJogo;
    }
    
}
