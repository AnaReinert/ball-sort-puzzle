# 🧩 Ball Sort Puzzle

Projeto desenvolvido em Java que implementa o jogo **Ball Sort Puzzle**, permitindo carregar diferentes configurações do puzzle e resolvê-lo automaticamente utilizando algoritmos de busca estudados em sala de aula.

Este trabalho foi desenvolvido como parte da disciplina de **Algoritmos e Estrutura de Dados**, com foco na aplicação prática de estruturas de dados, modelagem de estados e estratégias de busca em problemas computacionais.

---

## 🎮 Demonstração

Exemplo de execução em largura
<img width="905" height="515" alt="image" src="https://github.com/user-attachments/assets/26d9e72f-caff-40f3-9943-33f0a9a5a1e9" />

Exemplo em execução em profundidade
<img width="915" height="491" alt="image" src="https://github.com/user-attachments/assets/9c432168-aac6-433a-8cba-ef344d9a367a" />

Utilizando as setas, é possível observar todos os passos que o algoritmo fez para chegar no resultado final
---

## 🚀 Funcionalidades

* Interface gráfica desenvolvida em **Java Swing**
* Carregamento de puzzles a partir de arquivos `.txt`
* Execução automática da resolução do jogo
* Visualização do processo de solução
* Suporte a diferentes estratégias de busca

---

## 🧠 Conceitos Aplicados

* Estruturas de Dados
* Busca em Largura (BFS)
* Busca em Profundidade (DFS)
* Representação de estados e transições
* Problemas de espaço de estados

---

## 📂 Formato do Arquivo de Entrada

O puzzle é carregado a partir de um arquivo `.txt` no seguinte formato:

```
numeroDeTubos;listaDeCores
```

Exemplo:

```
6;#eb4034,#347deb,#34eb5b,#ebd834,#347deb,#eb4034,#ebd834,#34eb5b,#34eb5b,#ebd834,#347deb,#eb4034,#ebd834,#34eb5b,#eb4034,#347deb
```

* Cada cor representa uma bola
* Cada tubo comporta 4 bolas
* Tubos extras iniciam vazios

---

## ⚙️ Como Executar

1. Clone o repositório:

   ```
   git clone https://github.com/AnaReinert/ball-sort-puzzle.git
   ```

2. Abra o projeto em uma IDE Java (NetBeans, Eclipse ou VS Code).

3. Execute a classe BallSortPuzzle.java

---

## 👩‍💻 Autoria

Projeto desenvolvido para a disciplina de **Algoritmos e Estrutura de Dados**.

**Coautora:** Ana Reinert
Demais integrantes conforme especificado no trabalho acadêmico.

---

## 📌 Observações

Este projeto possui fins educacionais e tem como objetivo demonstrar a aplicação prática de algoritmos de busca e estruturas de dados em um problema clássico de organização e otimização.
