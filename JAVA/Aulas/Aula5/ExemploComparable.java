/* 
COMPARABLE
- Comparable: interface que define a
  ordem natural dos objetos.
- compareTo(T o): método que
  compara o objeto atual com outro
  do mesmo tipo
- Retorna:
    - Negativo se o atual é menor
      que o outro
    - Zero se são iguais
    - Positivo se o atual é maior que
      o outro
*/


// javac -d Classes ExemploComparable.java && java -cp Classes ExemploComparable
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Aluno implements Comparable<Aluno> {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public int compareTo(Aluno outro) {
        return this.nome.compareTo(outro.nome);
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Nota: " + nota;
    }
}

public class ExemploComparable {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("João", 8.5));
        alunos.add(new Aluno("Maria", 9.0));
        alunos.add(new Aluno("Pedro", 7.5));

        System.out.println("Lista de alunos antes da ordenação:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        Collections.sort(alunos); // Ordena a lista usando a ordem natural (por nome)

        System.out.println("\nLista de alunos após ordenação (por nome):");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}