/*
Exercício – Abstração de dados
Proposta de exercício para aplicar o conceito de Abstração de dados

Interfaces de acesso
Interfaces de acesso são contratos que definem:
    - Métodos que devem ser implementados por classes concretas
    - Padronização de comportamentos entre diferentes implementações
    - Desacoplamento entre código cliente e implementação específica
    - Flexibilidade para trocar implementações sem afetar o sistema

    Vantagens:
    - Facilita testes unitários (mocking)
    - Permite múltiplas implementações
    - Reduz dependências diretas
    - Melhora a manutenibilidade do código

    javac -d Classes ExemploRepositorio.java && java -cp Classes ExemploRepositorio
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// --- Classes de Suporte (criadas para o exemplo funcionar) ---

// A classe Usuario precisa ser "Serializable" para ser gravada em arquivo.
class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String email;

    public Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    
    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome='" + nome + "'}";
    }
}

// Classe de simulação para a conexão com o banco.
class ConexaoBanco {}


// --- Código dos Slides ---

// Interface define o contrato de acesso
interface RepositorioUsuario {
    void salvar(Usuario usuario);
    Usuario buscarPorId(Long id);
    List<Usuario> listarTodos();
    void deletar(Long id);
}

// Implementação que simula acesso a um Banco de Dados
class RepositorioUsuarioBD implements RepositorioUsuario {
    private ConexaoBanco conexao;

    @Override
    public void salvar(Usuario usuario) {
        // Implementação específica para BD
        String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";
        System.out.println("[BD] Executando SQL: " + sql); // Adicionado para usar a variável 'sql'
        System.out.println("[BD] Salvando usuário: " + usuario.getNome());
        // ... código de inserção no banco de dados
    }

    /* 
    @Override
    public void salvar(Usuario usuario) {
        // Implementação específica para BD
        String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";
        System.out.println("[BD] Salvando usuário: " + usuario.getNome());
        // ... código de inserção no banco de dados
    }
    */
    
    @Override
    public Usuario buscarPorId(Long id) {
        // Implementação específica para BD
        System.out.println("[BD] Buscando usuário com id: " + id);
        return null; // Simplificado
    }

    @Override
    public List<Usuario> listarTodos() {
        // Implementação específica para BD
        System.out.println("[BD] Listando todos os usuários.");
        return new ArrayList<>(); // Simplificado
    }

    @Override
    public void deletar(Long id) {
        // Implementação específica para BD
        System.out.println("[BD] Deletando usuário com id: " + id);
    }
}

// Implementação para persistência em arquivo
class RepositorioUsuarioArquivo implements RepositorioUsuario {
    private String caminhoDiretorio;

    public RepositorioUsuarioArquivo(String caminho) {
        this.caminhoDiretorio = caminho;
        new File(caminho).mkdirs(); // Cria o diretório se não existir
    }

    @Override
    public void salvar(Usuario usuario) {
        String caminhoArquivo = caminhoDiretorio + "/" + usuario.getId() + ".txt";
        //Serializar e salvar o usuário no arquivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(usuario);
            System.out.println("[Arquivo] Usuário salvo em: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {
        String caminhoArquivo = caminhoDiretorio + "/" + id + ".txt";
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Usuario) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Métodos que faltavam no slide, mas são exigidos pela interface
    @Override
    public List<Usuario> listarTodos() {
        System.out.println("[Arquivo] A listagem de todos os usuários não foi implementada.");
        return new ArrayList<>();
    }

    @Override
    public void deletar(Long id) {
        String caminhoArquivo = caminhoDiretorio + "/" + id + ".txt";
        File arquivo = new File(caminhoArquivo);
        if (arquivo.delete()) {
            System.out.println("[Arquivo] Usuário deletado: " + caminhoArquivo);
        }
    }
}


// --- Classe Principal para Execução ---
public class ExemploRepositorio {

    // Método principal que demonstra o uso das implementações
    public static void main(String[] args) {
        Usuario usuario = new Usuario(42L, "Alan Turing", "turing@bletchleypark.uk");

        System.out.println("--- Testando implementação com Banco de Dados ---");
        RepositorioUsuario repoBd = new RepositorioUsuarioBD();
        repoBd.salvar(usuario);
        repoBd.deletar(42L);

        System.out.println("\n--- Testando implementação com Arquivos ---");
        RepositorioUsuario repoArquivo = new RepositorioUsuarioArquivo("dados_usuarios");
        
        // Salva o usuário em arquivo
        repoArquivo.salvar(usuario);

        // Busca o mesmo usuário do arquivo para confirmar
        Usuario usuarioRecuperado = repoArquivo.buscarPorId(42L);
        System.out.println("Usuário recuperado do arquivo: " + usuarioRecuperado);
    }
}