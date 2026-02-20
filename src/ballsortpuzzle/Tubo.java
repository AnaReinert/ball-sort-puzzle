package ballsortpuzzle;

import java.util.Stack;

/**
 *
 * @author Ana Reinert e Gabriel 
 */
public class Tubo<String> extends Stack<String> {


    public boolean isFull() {
        return (this.size() == 4);
    }

    @Override
    public boolean equals(Object obj) {
        //Verifica se as variaveis estão referenciando o mesmo objeto em memória
        if (this == obj) {
            return true;
        }

        //Faz um cast do objeto recebido para Tubo
        Tubo outro = (Tubo) obj;

        //Comparando o tamanho de cada lista
        if (!(this.size() == outro.size())) {
            return false;
        }

        //Filas Auxiliares para guardar a informação
        Stack<String> pilhaAux1 = new Stack<>();
        Stack<String> pilhaAux2 = new Stack<>();

        //Verifica se as cores das bolas presentes em um tubo são iguais ao do segundo
        for (int i = 0; i < this.size(); i++) {

            pilhaAux1.add(this.peek());
            pilhaAux2.add((String) outro.peek().toString());

            if (!(this.pop().equals(outro.pop()))) {
                //Devolvendo as informações às pilhas antes de retornar false
                while (!(pilhaAux1.isEmpty() && pilhaAux2.isEmpty())) {
                    if (pilhaAux1.peek() != null) {
                        this.push(pilhaAux1.pop());
                    }

                    if (pilhaAux2.peek() != null) {
                        outro.push(pilhaAux2.pop());
                    }
                }
                return false;
            }
        }

        //Devolvendo as informações às pilhas antes de retornar true
        while (!(pilhaAux1.isEmpty() && pilhaAux2.isEmpty())) {
            if (pilhaAux1.peek() != null) {
                this.push(pilhaAux1.pop());
            }

            if (pilhaAux2.peek() != null) {
                outro.push(pilhaAux2.pop());
            }
        }

        return true;
    }

    //Método para verificar se o tubo está completo e todas as bolinhas são iguais
    public boolean verificaTuboConcluido() {
        if (!(this.isFull())) {
            return false;
        }
        //Recuperando a primeira bola
        String bola = this.peek();

        //Filas Auxiliares para guardar a informação
        Stack<String> pilhaAuxiliar = new Stack<>();

        //Verificando se as demais bolas correspondem a cor da primeira
        for (int i = 0; i < 4; i++) {
            pilhaAuxiliar.push(this.peek());
            if (!(this.pop().equals(bola))) {

                while (!(pilhaAuxiliar.isEmpty())) {
                    if (pilhaAuxiliar.peek() != null) {
                        this.push(pilhaAuxiliar.pop());
                    }
                }
                return false;
            }
        }
        while (!(pilhaAuxiliar.isEmpty())) {
            if (pilhaAuxiliar.peek() != null) {
                this.push(pilhaAuxiliar.pop());
            }
        }

        return true;
    }

    public Tubo copiar() {
        Stack<String> pilhaAuxiliar = new Stack<>();

        Tubo novoTubo = new Tubo();
        //Reempilhando
        while (!(this.isEmpty())) {
            pilhaAuxiliar.push(this.pop());
        }
        //Desempilhando
        while (!(pilhaAuxiliar.isEmpty())) {
            this.push(pilhaAuxiliar.peek());
            novoTubo.push(pilhaAuxiliar.pop());
        }

        return novoTubo;
    }
}
