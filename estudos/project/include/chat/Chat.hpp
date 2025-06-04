// include/chat/Chat.hpp
#ifndef CHAT_HPP
#define CHAT_HPP

#include "IMensagem.hpp"
#include <vector> // Para o histórico

namespace ChatApp { // Usando um namespace para "pacote diferente"

class Chat {
private:
    std::vector<IMensagem*> historicoMensagens; // Para guardar o histórico

public:
    Chat();
    ~Chat(); // Destrutor para liberar a memória do histórico
    void exibirMensagem(IMensagem& msg); // Método para exibir uma única mensagem
    void adicionarAoHistorico(IMensagem* msg); // Método para adicionar ao histórico
    void exibirHistorico(); // Método para exibir todas as mensagens do histórico
};

} // namespace ChatApp

#endif // CHAT_HPP
