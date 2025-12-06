Trabalho Final de Estruturas de Dados

📌 Descrição do Projeto

Este projeto implementa e compara o desempenho de diferentes estruturas de dados e algoritmos clássicos utilizando Java.
Foram avaliados:

Vetor

Árvore Binária de Busca (ABB)

Árvore AVL

Bubble Sort

QuickSort

Busca Sequencial

Busca Binária

O projeto realiza medições reais de tempo de execução (inserção, busca e ordenação) e exibe os resultados diretamente no terminal.

📁 Estrutura de Pastas
src/
 ├── estruturas/
 
 │     ├── Vetor.java
 
 │     ├── ABB.java
 
 │     └── AVL.java
 
 │
 
 ├── ordenacao/
 
 │     ├── BubbleSort.java
 
 │     └── QuickSort.java
 
 │
 
 ├── util/
 
 │     └── Utils.java
 
 │
 └── testes/
       └── TestRunner.java

▶️ Como Executar

Certifique-se de que todos os arquivos .java estão dentro de suas respectivas pastas.

Compile o projeto:

javac src/testes/TestRunner.java


Execute:

java testes.TestRunner


Os resultados aparecerão no terminal já formatados.

📊 O que o Programa Faz

O TestRunner executa automaticamente:

1️⃣ Testes de Inserção

Para:

Vetor

ABB

AVL
Com três conjuntos:

Ordenado

Inverso

Aleatório
E três tamanhos:

100

1000

10000

2️⃣ Testes de Busca

Realiza buscas por:

Primeiro elemento

Último

Meio

3 aleatórios existentes

1 inexistente

Com:

Vetor (Busca Sequencial e Binária)

ABB

AVL

3️⃣ Testes de Ordenação

Aplica os algoritmos:

Bubble Sort

QuickSort

Nos mesmos três conjuntos usados anteriormente.

🧠 Conclusões Gerais

A AVL apresentou o desempenho mais estável e eficiente entre as estruturas.

A ABB funciona bem apenas em dados aleatórios; degrada totalmente em ordenado e inverso.

O Vetor é extremamente eficiente para inserir, mas limitada em buscas.

O Bubble Sort é inviável para conjuntos grandes.

O QuickSort foi o mais eficiente, exceto em um caso ordenado (pior escolha de pivô).

👨‍💻 Autor

Rossandre Alex Cordeiro Nunes Filho
