# Makefile Corrigido para incluir a classe Chat

CC=g++
CFLAGS=-std=c++11 -Wall
TARGET=program

BUILD_DIR = ./build
SRC_DIR = ./src
INCLUDE_DIR = ./include

# Lista de todos os arquivos objeto
OBJS = ${BUILD_DIR}/MensagemTexto.o \
       ${BUILD_DIR}/MensagemImagem.o \
       ${BUILD_DIR}/MensagemAudio.o \
       ${BUILD_DIR}/Chat.o \
       ${BUILD_DIR}/main.o

# Alvo padrão: o programa final
all: ${TARGET}

# Regra para o executável final
${TARGET}: ${OBJS}
	$(shell mkdir -p ${BUILD_DIR}) # Cria o diretório build se não existir (garantia)
	${CC} ${CFLAGS} -o ${TARGET} ${OBJS} # Usa a lista de OBJS completa

# Regra genérica para criar o diretório BUILD_DIR (dependência de todos os .o)
${BUILD_DIR}:
	mkdir -p ${BUILD_DIR}

# Regra para compilar MensagemTexto.cpp
${BUILD_DIR}/MensagemTexto.o: ${SRC_DIR}/mensagem/MensagemTexto.cpp ${INCLUDE_DIR}/mensagem/IMensagem.hpp ${INCLUDE_DIR}/mensagem/MensagemTexto.hpp | ${BUILD_DIR}
	${CC} ${CFLAGS} -I ${INCLUDE_DIR}/mensagem/ -c $< -o $@

# Regra para compilar MensagemImagem.o
${BUILD_DIR}/MensagemImagem.o: ${SRC_DIR}/mensagem/MensagemImagem.cpp ${INCLUDE_DIR}/mensagem/IMensagem.hpp ${INCLUDE_DIR}/mensagem/MensagemImagem.hpp | ${BUILD_DIR}
	${CC} ${CFLAGS} -I ${INCLUDE_DIR}/mensagem/ -c $< -o $@

# Regra para compilar MensagemAudio.o
${BUILD_DIR}/MensagemAudio.o: ${SRC_DIR}/mensagem/MensagemAudio.cpp ${INCLUDE_DIR}/mensagem/IMensagem.hpp ${INCLUDE_DIR}/mensagem/MensagemAudio.hpp | ${BUILD_DIR}
	${CC} ${CFLAGS} -I ${INCLUDE_DIR}/mensagem/ -c $< -o $@

# Regra para compilar Chat.cpp (NOVA REGRA)
${BUILD_DIR}/Chat.o: ${SRC_DIR}/chat/Chat.cpp ${INCLUDE_DIR}/chat/Chat.hpp ${INCLUDE_DIR}/mensagem/IMensagem.hpp | ${BUILD_DIR}
	${CC} ${CFLAGS} -I ${INCLUDE_DIR}/chat/ -I ${INCLUDE_DIR}/mensagem/ -c $< -o $@

# Regra para compilar main.o
${BUILD_DIR}/main.o: ${SRC_DIR}/main.cpp ${INCLUDE_DIR}/mensagem/IMensagem.hpp ${INCLUDE_DIR}/mensagem/MensagemTexto.hpp ${INCLUDE_DIR}/mensagem/MensagemImagem.hpp \
${INCLUDE_DIR}/mensagem/MensagemAudio.hpp ${INCLUDE_DIR}/chat/Chat.hpp | ${BUILD_DIR}
	${CC} ${CFLAGS} -I ${INCLUDE_DIR}/mensagem/ -I ${INCLUDE_DIR}/chat/ -c $< -o $@

# Regra para limpar arquivos gerados durante a compilação.
.PHONY: all clean

clean:
	rm -rf ${BUILD_DIR} ${TARGET}
