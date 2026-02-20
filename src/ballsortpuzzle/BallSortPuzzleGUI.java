package ballsortpuzzle;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Nodo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BallSortPuzzleGUI extends JFrame implements ActionListener {

    //Variaveis do programa
    Queue<String> bolas;
    int quantidadeTubos;
    private final ArrayList<Tubo> novoEstadoBallPuzzle = new ArrayList<>(quantidadeTubos);
    //Variaveis da GUI
    JButton btSelecionarPuzzle;

    BallSortPuzzleGUI() {
        //Configurações básicas da tela
        this.setTitle("Ball Sort Puzzle!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);
        this.getContentPane().setBackground(new Color(44, 47, 51));
        this.setVisible(true);

        btSelecionarPuzzle = new JButton("Selecionar Puzzle");
        btSelecionarPuzzle.addActionListener(this);
        btSelecionarPuzzle.setBounds(350, 200, 300, 75);
        this.add(btSelecionarPuzzle);

        //Configurações do botão       
    }

    public void criarTubos() {
        for (int i = 0; i < quantidadeTubos; i++) {
            novoEstadoBallPuzzle.add(new Tubo());
        }

        for (int i = 0; i < novoEstadoBallPuzzle.size() - 2; i++) {
            while (!(novoEstadoBallPuzzle.get(i).isFull())) {
                String bola = bolas.remove();
                novoEstadoBallPuzzle.get(i).push(bola);
            }
        }
    }

    public void testarPuzzle() throws Exception {
        //Definindo o Estado Inicial 

        criarTubos();

        BallSortPuzzle ballPuzzle = new BallSortPuzzle(novoEstadoBallPuzzle);
//        System.out.println("busca em largura");
        BuscaLargura<BallSortPuzzle> bLarg = new BuscaLargura<>();
        Nodo n = bLarg.busca(ballPuzzle);
        
        // chama busca em profundidade
	    System.out.println("busca em profundidade");
	    n = new BuscaProfundidade<BallSortPuzzle>().busca(ballPuzzle);
	    if (n == null) {
	        System.out.println("sem solucao!");
	    } else {
	    	System.out.println(n.getProfundidade());
	        System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
	    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Ação do botão de Selecionar Puzzle
        if (e.getSource() == btSelecionarPuzzle) {
            //Abrindo o FileChooser
            
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            //Verificando se um arquivo foi selecionado 
            if (response == JFileChooser.APPROVE_OPTION) {
                //Pegando a rota do arquivo
                File puzzle = new File(fileChooser.getSelectedFile().getAbsolutePath());
             
            //Lendo o arquivo
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(puzzle))) {
                    String primeiraLinha = reader.readLine().trim();
                    //Recuperando o número de tubos
                    String[] metade = primeiraLinha.split(";");
                    quantidadeTubos = Integer.parseInt(metade[0]);

                    //Recuperando a cor de cada bolinha e as organizando na fila
                    String[] cores = metade[1].split(",");
                    bolas = new LinkedList<String>();
                    //Passando as bolinhas do array para a fila
                    Collections.addAll(bolas, cores);
                }

                //Testando o Puzzle
                testarPuzzle();

            } catch (Exception ex) {
                Logger.getLogger(BallSortPuzzleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
}
