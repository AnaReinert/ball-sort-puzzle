package ballsortpuzzle;

import busca.Estado;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ana e Gabriel
 */
public class BallSortPuzzle implements Estado {

    private final ArrayList<Tubo> novoEstadoBallPuzzle;

    BallSortPuzzle(ArrayList<Tubo> novoEstadoBallPuzzle) {
        this.novoEstadoBallPuzzle = novoEstadoBallPuzzle;
    }
    
    public ArrayList<Tubo> getNovoEstadoBallPuzzle() {
        return novoEstadoBallPuzzle;
    }

    //Método usado apenas para testes
    public Tubo getTubo(int n) {
        if (n > novoEstadoBallPuzzle.size() || n < 0) {
            return null;
        }

        return novoEstadoBallPuzzle.get(n);
    }

    @Override
    public String getDescricao() {
        return null;
    }

    @Override
    public boolean ehMeta() {
        int count = 0;
        for (int i = 0; i < novoEstadoBallPuzzle.size(); i++) {
            if (novoEstadoBallPuzzle.get(i).verificaTuboConcluido()
                    || novoEstadoBallPuzzle.get(i).isEmpty()) {
                count++;
            }
        }
        return count == novoEstadoBallPuzzle.size();
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        BallSortPuzzle outro = (BallSortPuzzle) obj;
        int count = 0;
        for (int i = 0; i < novoEstadoBallPuzzle.size(); i++) {
            for (int j = 0; j < novoEstadoBallPuzzle.size(); j++) {
                if (novoEstadoBallPuzzle.get(i).equals(outro.novoEstadoBallPuzzle.get(j))) {
                    count++;
                    break;
                }
            }
        }
        return count == novoEstadoBallPuzzle.size();
    }

    @Override
    public String toString() {
        String estado = "";
        for (int i = 0; i < novoEstadoBallPuzzle.size(); i++) {
            estado += novoEstadoBallPuzzle.get(i).toString() + "\n";
        }
        return estado;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public ArrayList<Tubo> copiarEstado() {
    return new ArrayList<>(novoEstadoBallPuzzle);
    }

    private ArrayList<Tubo> resetarEstado(ArrayList<Tubo> estado) {
        novoEstadoBallPuzzle.clear();

        for (int i = 0; i < estado.size(); i++) {
            novoEstadoBallPuzzle.add(estado.get(i).copiar());
        }

        return novoEstadoBallPuzzle;
    }

    @Override
    public List<BallSortPuzzle> sucessores() {
        List<BallSortPuzzle> suc = new LinkedList<>();

        //Você pega o estado atual
        ArrayList<Tubo> parent = copiarEstado();

        //Primeiro for é destinado a rodar os tubos (ArrayList)
        for (int i = 0; i < novoEstadoBallPuzzle.size(); i++) {
            //Reseta para verificar a jogada possível da próxima bola sem as alterações anteriores
            resetarEstado(parent);

            //O tubo atual não é vazio? 
            if (!novoEstadoBallPuzzle.get(i).isEmpty()) {

                //Seu tubo não esta completo?         
                if (!novoEstadoBallPuzzle.get(i).verificaTuboConcluido()) {

                    //Pegar a bola do tubo atual
                    String bola = (String) novoEstadoBallPuzzle.get(i).peek();

                    //Comparação com cada um dos tubos se...
                    for (int j = 0; j < novoEstadoBallPuzzle.size(); j++) {
                        //Reseta para verificar a jogada possível no próximo tubo com a mesma bola
                        resetarEstado(parent);

                        //O tubo atual é o mesmo que o tubo sendo comparado?
                        if (i != j) {

//                          Quais são os tubos elegíveis a receber a bolinha?
//                          O tubo atual que estamos comparando é vazio?
                            if (novoEstadoBallPuzzle.get(j).isEmpty()) {
                                novoEstadoBallPuzzle.get(i).pop();
                                novoEstadoBallPuzzle.get(j).push(bola);
                                //Gerando sucessor
                                ArrayList<Tubo> estado = copiarEstado();
                                BallSortPuzzle sucessor = new BallSortPuzzle(estado);
                                suc.add(sucessor);
                            } else {
                                //Caso não seja vazio...
                                //O tubo tem espaço, e a primeira bolinha do tubo 
                                //tem a mesma cor que a minha?
                                if ((!novoEstadoBallPuzzle.get(j).isFull())
                                        && (novoEstadoBallPuzzle.get(j).peek().equals(bola))) {

                                    novoEstadoBallPuzzle.get(i).pop();
                                    novoEstadoBallPuzzle.get(j).push(bola);
                                    ArrayList<Tubo> estado = copiarEstado();
                                    BallSortPuzzle sucessor = new BallSortPuzzle(estado);
                                    suc.add(sucessor);
                                }
                            }
                        }
                    }
                }
            }
        }
        return suc;
    }

}
