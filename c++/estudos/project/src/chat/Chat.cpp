// src/chat/Chat.cpp
#include "../../include/chat/Chat.hpp"
#include <iostream>

namespace ChatApp {

Chat::Chat() {
    // Construtor, se precisar de alguma inicialização específica
}

Chat::~Chat() {
    // Liberar a memória de todas as mensagens no histórico
    for (IMensagem* msg : historicoMensagens) {
        delete msg;
    }
    historicoMensagens.clear();
}

void Chat::exibirMensagem(IMensagem& msg) {
    msg.exibir();
}

void Chat::adicionarAoHistorico(IMensagem* msg) {
    // Adiciona uma mensagem ao histórico. Assume que a mensagem foi alocada dinamicamente.
    historicoMensagens.push_back(msg);
}

void Chat::exibirHistorico() {
    std::cout << "\n--- Historico de Mensagens ---" << std::endl;
    for (IMensagem* msg : historicoMensagens) {
        msg->exibir();
    }
    std::cout << "--- Fim do Historico ---\n" << std::endl;
}

} // namespace ChatApp
