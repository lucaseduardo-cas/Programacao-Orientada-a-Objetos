// include/mensagem/IMensagem.hpp
#ifndef IMENSAGEM_HPP
#define IMENSAGEM_HPP

class IMensagem {
public:
    virtual void exibir() = 0; // Método puramente virtual
    virtual ~IMensagem() {} // Destrutor virtual para garantir a desalocação correta
};

#endif // IMENSAGEM_HPP
