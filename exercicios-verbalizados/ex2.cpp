#include <iostream>
#include <string>

class Aluno {
private:
	std::string nome; //Atributo
	int idade;
	std::string curso;
	int matricula;

public:
	// Construtor
	Aluno(const std::string& nome, int idade, const std::string& curso, int matricula)
	: nome(nome), idade(idade), curso(curso), matricula(matricula) {}

	// Método para exibir o nome do aluno
	void exibirDados() const {
		std::cout << "nome: " << nome << std::endl;
		std::cout << "Idade: " << idade << " anos" << std::endl;
		std::cout << "Curso: " << curso << std::endl;
		std::cout << "Matrícula: " << matricula << std::endl;
	}

	// Método para alterar o curso do aluno
	void alterarCurso(const std::string& novoCurso) {
		curso = novoCurso;
	}
};

int main (int argc, char* argv[] ) {
	if (argc != 5) {
		std::cerr <<"Uso: " << argv[0] << " <nome> <idade> <curso> <matricula>" << std::endl;
		return 1;
	}

	// Captura os argumentos da linha de comando
	std::string nome = argv[1];
	int idade = std::stoi(argv[2]); // Converte string para inteiro
	std::string curso = argv[3];
	int matricula = std::stoi(argv[4]); // Converte string para inteiro

	// Criando um objeto Aluno
	Aluno aluno1(nome, idade, curso, matricula);

	// Exibindo o nome do aluno

	aluno1.exibirDados();

	// Alterando o curso do aluno
	std::cout << "\nAlterando curso para 'Engenharia de Software'...\n";
	aluno1.alterarCurso("Engenharia de Software");

	// Exibindo os dados atualizados
	aluno1.exibirDados();

	return 0;
}
