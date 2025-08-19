// include/mensagem/MensagemTexto.hpp
#ifndef MENSAGEMTEXTO_H
#define MENSAGEMTEXTO_H

#include <string>
#include "IMensagem.hpp"

class MensagemTexto : public IMensagem {
private:
    std::string _msg;

public:
    MensagemTexto(std::string msg);
    void exibir();
};

#endif // MENSAGEMTEXTO_HPP
