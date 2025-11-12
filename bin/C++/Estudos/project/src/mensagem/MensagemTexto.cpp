#include <iostream>
#include "MensagemTexto.hpp"

MensagemTexto::MensagemTexto(std::string msg) {
    this->_msg = msg;
}
void MensagemTexto::exibir() {
    std::cout << this->_msg << std::endl;
}
