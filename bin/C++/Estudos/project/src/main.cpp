/*
cd /mnt/c/Users/Usuario/Documents/UEG-SI/3-Periodo/poo-i/estudos/project
make clean
make
./program
*/

// src/main.cpp
#include <iostream>
#include <vector>
#include "../include/mensagem/IMensagem.hpp"
#include "../include/mensagem/MensagemTexto.hpp"
#include "../include/mensagem/MensagemImagem.hpp"
#include "../include/mensagem/MensagemAudio.hpp"
#include "../include/chat/Chat.hpp" // Inclui a nova classe Chat

int main() {
    // Crie uma instância da classe Chat
    ChatApp::Chat meuChat;

    // Criando mensagens para exibição e histórico
    // Lembre-se: se você adicionar ao histórico, a classe Chat será responsável por deletar.
    // Se for só para exibir, alocar na stack é mais simples.

    MensagemTexto texto1("Oi, tem aula de PDS2 hoje?");
    MensagemAudio audio1("audio.wav");
    MensagemImagem imagem1("imagem03.ascii");
    MensagemTexto texto2("Mas que puxa :(");

    // Exibindo mensagens usando o método da classe Chat
    std::cout << "--- Exibicao Direta de Mensagens ---" << std::endl;
    meuChat.exibirMensagem(texto1);
    meuChat.exibirMensagem(audio1);
    meuChat.exibirMensagem(imagem1);
    meuChat.exibirMensagem(texto2);

    // Adicionando mensagens ao histórico (precisam ser alocadas dinamicamente)
    // CUIDADO: Estas mensagens serão gerenciadas e deletadas pelo Chat.
    meuChat.adicionarAoHistorico(new MensagemTexto("Mensagem 1 no historico!"));
    meuChat.adicionarAoHistorico(new MensagemAudio("notificacao.mp3"));
    meuChat.adicionarAoHistorico(new MensagemImagem("smile.ascii")); // Crie este arquivo também!

    // Exibindo o histórico
    meuChat.exibirHistorico();

    return 0;
}
