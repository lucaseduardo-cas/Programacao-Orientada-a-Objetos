// src/mensagem/MensagemAudio.cpp
#include <iostream>
#include "MensagemAudio.hpp" // AGORA ESTÁ CERTO!

MensagemAudio::MensagemAudio(std::string audio) {
    this->_audio = audio;
}

void MensagemAudio::exibir() {
    std::cout << "Tocando o arquivo... ";
    std::cout << this->_audio;
    std::cout << std::endl;
}

