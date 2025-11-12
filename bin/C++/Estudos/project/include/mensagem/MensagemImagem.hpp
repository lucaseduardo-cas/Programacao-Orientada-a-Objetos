// include/mensagem/MensagemImagem.hpp
#ifndef MENSAGEMIMAGEM_H
#define MENSAGEMIMAGEM_H

#include <string>
#include "IMensagem.hpp"

class MensagemImagem : public IMensagem {
private:
    std::string _imagem;

public:
    MensagemImagem(std::string imagem);
    void exibir();
};

#endif // MENSAGEMIMAGEM_HPP
