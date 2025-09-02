/*
 * Padrão de projeto: DAO (Data Access Object)
 *
 * O padrão DAO é uma abordagem para separar a lógica de acesso a dados
 * da lógica de negócios de uma aplicação. Ele fornece uma interface
 * para realizar operações de CRUD (Create, Read, Update, Delete) em
 * objetos de domínio, permitindo que a aplicação interaja com diferentes
 * fontes de dados de forma transparente.
 *
 * A implementação envolve criar uma interface que define os métodos de
 * acesso e uma ou mais classes concretas que implementam essa interface,
 * interagindo com a fonte de dados.
 * 
   javac -d Classes ExemploDAO.java && java -cp Classes ExemploDAO
 */

import java.util.List;
import java.util.ArrayList;

// --- Classes de Suporte (criadas para o exemplo funcionar) ---

// Representa o objeto de domínio
class Usuario {
    private Long id;
    private String nome;

    public Usuario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome='" + nome + "'}";
    }
}

// Simula a conexão com o banco de dados
class ConexaoBanco {
    public ConexaoBanco() {
        System.out.println("Conexão com o banco de dados estabelecida.");
    }
}

// --- Código dos Slides ---

// Interface DAO que define o contrato de acesso
interface UsuarioDAO {
    void salvar(Usuario usuario);
    Usuario buscarPorId(Long id);
    List<Usuario> listarTodos();
    void deletar(Long id);
}

// Implementação concreta da interface DAO
class UsuarioDAOImpl implements UsuarioDAO {
    private ConexaoBanco conexao;

    public UsuarioDAOImpl(ConexaoBanco conexao) {
        this.conexao = conexao;
    }

    @Override
    public void salvar(Usuario usuario) {
        // LOGICA PARA SALVAR O USUÁRIO NO BANCO DE DADOS
        System.out.println("SALVANDO: " + usuario.getNome());
    }

    @Override
    public Usuario buscarPorId(Long id) {
        // LOGICA PARA BUSCAR O USUÁRIO POR ID NO BANCO DE DADOS
        System.out.println("BUSCANDO: Usuário com id " + id);
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        // LOGICA PARA LISTAR TODOS OS USUÁRIOS NO BANCO DE DADOS
        System.out.println("LISTANDO: Todos os usuários.");
        return new ArrayList<>();
    }

    @Override
    public void deletar(Long id) {
        // LOGICA PARA DELETAR O USUÁRIO NO BANCO DE DADOS
        System.out.println("DELETANDO: Usuário com id " + id);
    }
}

// --- Classe Principal para Execução ---
public class ExemploDAO {
    public static void main(String[] args) {
        // 1. Prepara a dependência (conexão)
        ConexaoBanco conexao = new ConexaoBanco();

        // 2. Cria a implementação do DAO, injetando a dependência
        //    A variável é do tipo da interface para desacoplar o código.
        UsuarioDAO usuarioDao = new UsuarioDAOImpl(conexao);

        // 3. Usa o DAO para manipular os dados
        System.out.println("\n--- Operações DAO ---");
        Usuario usuario = new Usuario(1L, "Charles Babbage");
        
        usuarioDao.salvar(usuario);
        usuarioDao.buscarPorId(1L);
        usuarioDao.listarTodos();
        usuarioDao.deletar(1L);
    }
}