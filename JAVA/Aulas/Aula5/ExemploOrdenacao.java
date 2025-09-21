/* 
Ordenação em List
    - Collections.sort(list): ordena a lista em ordem natural (alfabética, numérica).
    - Comparator: permite definir critérios personalizados de ordenação.
    
    List<String> nomes = new ArrayList<>();
    nomes.add("João");
    nomes.add("Maria");
    nomes.add("Pedro");
    Collections.sort(nomes); // Ordem alfabética

    List<Aluno> alunos = new ArrayList<>();
    alunos.add(new Aluno("João", 8.5));
    alunos.add(new Aluno("Maria", 9.0));    
    alunos.add(new Aluno("Pedro", 7.5));
    Collections.sort(alunos); // Requer que Aluno implemente Comparable<Aluno>
*/

// javac -d Classes ExemploOrdenacao.java && java -cp Classes ExemploOrdenacao
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
    public int compareTo(Aluno outroAluno) {
        // Ordena por nota em ordem decrescente
        if (this.nota < outroAluno.nota) {
            return 1;
        }
        if (this.nota > outroAluno.nota) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Nota: " + nota;
    }
}

public class ExemploOrdenacao {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("João", 8.5));
        alunos.add(new Aluno("Maria", 9.0));
        alunos.add(new Aluno("Pedro", 7.5));

        System.out.println("Lista de alunos antes da ordenação:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        Collections.sort(alunos); // Ordena a lista com base no compareTo da classe Aluno

        System.out.println("\nLista de alunos após ordenação (por nota decrescente):");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
