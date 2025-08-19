// include/mensagem/MensagemAudio.hpp
#ifndef MENSAGEMAUDIO_H
#define MENSAGEMAUDIO_H

#include <string>
#include "IMensagem.hpp"

class MensagemAudio : public IMensagem {
private:
    std::string _audio;

public:
    MensagemAudio(std::string audio);
    void exibir();
};

#endif // MENSAGEMAUDIO_HPP
