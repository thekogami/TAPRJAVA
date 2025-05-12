import hashlib

# Lê o cabeçalho (caracteres codificados) e os dados binários compactados
def ler_cabecalho_e_dados(nome_arquivo):
    with open(nome_arquivo, "rb") as f:
        linhas = f.read().split(b'\n', 1)
        caracteres = linhas[0].decode("utf-8").split('|')
        binario = linhas[1]
    return caracteres, binario

# Converte os bytes de volta para a string de bits
def bytes_para_bits(binario):
    padding = binario[0]  # o primeiro byte indica quantos zeros foram adicionados no final
    bits = bin(int.from_bytes(binario[1:], "big"))[2:]

    # Preenche com zeros à esquerda se faltar bits
    while len(bits) % 8 != 0:
        bits = "0" + bits

    # Remove o padding
    return bits[:-padding]

# Cria o mapa de decodificação reversa (de código binário para caractere)
def construir_decodificacao(caracteres):
    return {format(i, "05b"): c for i, c in enumerate(caracteres)}

# Percorre a string de bits e reconstrói o texto original
def descompactar(bits, mapa_decodificacao):
    resultado = ""
    buffer = ""

    # Concatena bit a bit até encontrar um código válido no mapa
    for bit in bits:
        buffer += bit
        if buffer in mapa_decodificacao:
            resultado += mapa_decodificacao[buffer]
            buffer = ""
    return resultado

def main():
    # Lê os dados do arquivo .squeezed
    caracteres, binario = ler_cabecalho_e_dados("arquivo1.txt.squeezed")

    # Converte o binário em bits e remove o padding
    bits = bytes_para_bits(binario)

    # Reconstrói o mapa de decodificação
    mapa_decodificacao = construir_decodificacao(caracteres)

    # Descompacta para recuperar o texto original
    texto_recuperado = descompactar(bits, mapa_decodificacao)

    # Salva em um novo arquivo restaurado
    with open("arquivo1_restaurado.txt", "w", encoding="utf-8") as f:
        f.write(texto_recuperado)

    # Exibe o hash MD5 do texto restaurado
    print("MD5 restaurado:", hashlib.md5(texto_recuperado.encode()).hexdigest())

if __name__ == "__main__":
    main()
