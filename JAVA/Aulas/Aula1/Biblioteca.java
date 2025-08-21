/*
UML – VISÃO GERAL

Definições: UML (Unified Modeling Language) é uma linguagem de
modelagem padrão para visualizar, especificar, construir e documentar
sistemas orientados a objetos através de diagramas que representam
diferentes aspectos do sistema.
Exemplos práticos
Diagramas UML quando aplicável 

+-----------------------------+           +-------------------------+
| -nome: String               |           | -titulo: String         |
| -livros: List               |           | -autor: String          |
+-----------------------------+           +-------------------------+
| +addLivro(Livro livro)      |         * | +getTitulo()            |
| +buscarLivro(String texto)  |-----------| +getTitulo()            |
|                             |           |                         |
|                             |           |                         |
+-----------------------------+           +-------------------------+  

*/

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivro(String titulo) {
        return livros.stream()
                .filter(l -> l.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }
    
    public static void main(String[] args) {
        // Criando a biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");

        // Criando alguns livros
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien");
        Livro livro2 = new Livro("O Hobbit", "J.R.R. Tolkien");

        // Adicionando os livros à biblioteca
        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);

        // Buscando um livro existente
        Livro livroEncontrado = biblioteca.buscarLivro("O Hobbit");
        if (livroEncontrado != null) {
            System.out.println("Livro encontrado: " + livroEncontrado.getTitulo() + " por " + livroEncontrado.getAutor());
        } else {
            System.out.println("Livro não encontrado.");
        }

        // Buscando um livro que não existe
        Livro livroNaoEncontrado = biblioteca.buscarLivro("A Batalha do Apocalipse");
        if (livroNaoEncontrado != null) {
            System.out.println("Livro encontrado: " + livroNaoEncontrado.getTitulo());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}

// Relacionamento: Biblioteca <>--- Livro (agregação)
class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}